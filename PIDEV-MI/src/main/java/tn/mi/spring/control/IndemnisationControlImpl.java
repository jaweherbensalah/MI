package tn.mi.spring.control;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Indemnisation;
import tn.esprit.spring.entity.REGION;
import tn.esprit.spring.entity.SANTE;
import tn.esprit.spring.entity.Type_Prod;
import tn.esprit.spring.entity.Virement;
import tn.esprit.spring.service.IIndemnisationService;

@Scope(value = "session")
@Controller(value = "indemnisationController") 
@ELBeanName(value = "indemnisationController") 
@Join(path = "/", to = "/Indemnisation.jsf")
@Named("indemnisationController")// pour view
@ViewScoped
@RequestScoped
@ManagedBean
public class IndemnisationControlImpl {
	@Autowired
	IIndemnisationService indemService;
	private Long num_ind;
	private Long num_indupdate;
	private Long id;
	private String nomClient;
	private Date date_debut;
	private Date date_fin;
	private int quantite;
	SANTE sante;
	REGION region;
	Type_Prod  type_produit;
	Virement virement;
	private String email;
	private Indemnisation indemnisation;
	public List <Indemnisation> indemnisations;
	
	public Virement[] getVirements() {
		return Virement.values();
	}

	public Type_Prod[] getType_Prods() {
		return Type_Prod.values();
	}
	public SANTE[] getSantes() {
		return SANTE.values();
	}

	public REGION[] getRegions() {
		return REGION.values();
	}
	
	// ajouter les getters et setters
	////ajouter une indemnisation
	public void addindemnisation(){
		indemService.addIndemn(new Indemnisation(id,nomClient,date_debut,date_fin,quantite,type_produit,sante,region,virement,email));
		
	}
	
	///recuperer toutes les indemnisations
	public List <Indemnisation> getIndemnisations(){
		return indemService.retrieveAllIndemn();
		
	}
	
	// supprimer une indemn
	public void removeIndemnisation(String num_ind){
		indemService.deleteIndemn(num_ind);
	}
	// affichage
	public void displayIndemnisation(Indemnisation indem){
		this.setId(indem.getId());
		this.setNomClient(indem.getNom());
		this.setDate_debut(indem.getDate_debut());
		this.setDate_fin(indem.getDate_fin());
		this.setQuantite(indem.getQuantite());
		this.setNum_indupdate(indem.getNum_ind());
		this.setType_produit(indem.getType_produit());
		this.setVirement(indem.getVirement());
		this.setSante(indem.getSante());
		this.setRegion(indem.getRegion());
		this.setEmail(indem.getEmail());	
		
		
	}
	
/////mise a jour
	public void UpdateIndemnisation(){
		Indemnisation indem=new Indemnisation(num_indupdate,id,nomClient,date_debut,date_fin,quantite,type_produit,sante,region,virement,email);
	     indemService.updateIndemn(indem);
	    
	}
	//message afficher
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
	    FacesContext.getCurrentInstance().
	            addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showInfo() {
	    addMessage(FacesMessage.SEVERITY_INFO, "AJOUT", "l'indemnisation est bien ajoutée");
	}
	public void showInfosupp() {
	    addMessage(FacesMessage.SEVERITY_INFO, "SUPPRIMER", "l'indemnisation est bien supprimée");
	}
	public void showInfomodifier() {
	    addMessage(FacesMessage.SEVERITY_INFO, "MODIFIER", "l'indemnisation est bien modifiée");
	}

////////////////////////////////////////////////
////////////////////////////////////
//SATISTIQUE
/////////////////////
///////////////////
	private BarChartModel barModel;
	private HorizontalBarChartModel horizontalBarModel;
	private PieChartModel pie;

	@PostConstruct 

	public void init(){
		createBarModels();
		createPie();
	}
	private void createPie() {
	pie=new PieChartModel();
	pie.set("Agricole", indemService.StatiqueIndemnisationAgricole());
	pie.set("Sante", indemService.StatiqueIndemnisationSante());
	pie.set("Education", indemService.StatiqueIndemnisationEducation());
	pie.setTitle("statistiques des indemnisations");
	pie.setLegendPosition("e");

	}

	private void createBarModels() {
		createBarModel();
		createHorizontalBarModel();
		
	}
	private void createHorizontalBarModel() {
		horizontalBarModel=new HorizontalBarChartModel();
		ChartSeries Indemnisations= new ChartSeries();
		Indemnisations.setLabel("Indemnisations");
		Indemnisations.set(Indemnisations, indemService.SommeMontantIndemnisation());
		ChartSeries agricole= new ChartSeries();
		agricole.setLabel("agricole");
		agricole.set(agricole, indemService.SommeMontantIndemnisationAgricole());
		ChartSeries Sante= new ChartSeries();
		Sante.setLabel("Sante");
		Sante.set(Sante, indemService.SommeMontantIndemnisationSante());
		ChartSeries Education= new ChartSeries();
		Education.setLabel("Education");
		Education.set(Education, indemService.SommeMontantIndemnisationEducation());
		horizontalBarModel.addSeries(Indemnisations);
		horizontalBarModel.addSeries(agricole);
		horizontalBarModel.addSeries(Sante);
		horizontalBarModel.addSeries(Education);
		horizontalBarModel.setTitle("somme de montants des indemnisations de chaque type");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);
		Axis xAxis=horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("sommes totales");
		xAxis.setMin(0);
		xAxis.setMax(200000);
		Axis yAxis=horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("indemnisations");
		
	}
	private void createBarModel() {
		barModel=initBarModel();
		barModel.setTitle("nombre des indemnisations  de chaque produit");
		barModel.setLegendPosition("ne");
		Axis xAxis=barModel.getAxis(AxisType.X);
		xAxis.setLabel("indemnisations");
		xAxis.setMin(0);
		xAxis.setMax(200);
		Axis yAxis=barModel.getAxis(AxisType.Y);
		yAxis.setLabel("nombres");
		yAxis.setMin(0);
		yAxis.setMax(200);
		
		
		
	}
	private BarChartModel initBarModel() {
		BarChartModel model= new BarChartModel();
		ChartSeries Indemnisations= new ChartSeries();
		Indemnisations.setLabel("Indemnisations");
		Indemnisations.set(Indemnisations, indemService.nbreIndemnisation());
		ChartSeries agricole= new ChartSeries();
		agricole.setLabel("agricole");
		agricole.set(agricole, indemService.nbreIndemnisationAgricole());

		ChartSeries Sante= new ChartSeries();
		Sante.setLabel("Sante");
		Sante.set(Sante, indemService.nbreIndemnisationSante());
		
		ChartSeries Education= new ChartSeries();
		Education.setLabel("Education");
		Education.set(Education, indemService.nbreIndemnisationEducation());


		
		model.addSeries(Indemnisations);
	    model.addSeries(agricole);

		model.addSeries(Sante);
	    model.addSeries(Education);
		return model;
	}
	/**
	 * @return the barModel
	 */
	public BarChartModel getBarModel() {
		return barModel;
	}
	/**
	 * @param barModel the barModel to set
	 */
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	/**
	 * @return the horizontalBarModel
	 */
	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}
	/**
	 * @param horizontalBarModel the horizontalBarModel to set
	 */
	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

	/**
	 * @return the pie
	 */
	public PieChartModel getPie() {
		return pie;
	}

	/**
	 * @param pie the pie to set
	 */
	public void setPie(PieChartModel pie) {
		this.pie = pie;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the num_ind
	 */
	public Long getNum_ind() {
		return num_ind;
	}
	/**
	 * @param num_ind the num_ind to set
	 */
	public void setNum_ind(Long num_ind) {
		this.num_ind = num_ind;
	}
	/**
	 * @return the num_indupdate
	 */
	public Long getNum_indupdate() {
		return num_indupdate;
	}
	/**
	 * @param num_indupdate the num_indupdate to set
	 */
	public void setNum_indupdate(Long num_indupdate) {
		this.num_indupdate = num_indupdate;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}
	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	/**
	 * @return the date_debut
	 */
	public Date getDate_debut() {
		return date_debut;
	}
	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	/**
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		return date_fin;
	}
	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	/**
	 * @return the type_produit
	 */
	public Type_Prod getType_produit() {
		return type_produit;
	}
	/**
	 * @param type_produit the type_produit to set
	 */
	public void setType_produit(Type_Prod type_produit) {
		this.type_produit = type_produit;
	}
	/**
	 * @return the virement
	 */
	public Virement getVirement() {
		return virement;
	}
	/**
	 * @param virement the virement to set
	 */
	public void setVirement(Virement virement) {
		this.virement = virement;
	}
	/**
	 * @return the sante
	 */
	public SANTE getSante() {
		return sante;
	}

	/**
	 * @param sante the sante to set
	 */
	public void setSante(SANTE sante) {
		this.sante = sante;
	}

	/**
	 * @return the region
	 */
	public REGION getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(REGION region) {
		this.region = region;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the indemnisation
	 */
	public Indemnisation getIndemnisation() {
		return indemnisation;
	}

	/**
	 * @param indemnisation the indemnisation to set
	 */
	public void setIndemnisation(Indemnisation indemnisation) {
		this.indemnisation = indemnisation;
	}

	/**
	 * @return the indemnisations
	 */


	/**
	 * @param indemnisations the indemnisations to set
	 */
	public void setIndemnisations(List<Indemnisation> indemnisations) {
		this.indemnisations = indemnisations;
	}

	public IndemnisationControlImpl() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
