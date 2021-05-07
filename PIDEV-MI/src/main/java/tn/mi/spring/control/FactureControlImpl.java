package tn.mi.spring.control;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.config.PrimeConfiguration;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.context.PrimeFacesContextFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Paiement;

import tn.esprit.spring.entity.Type_Prod;

import tn.esprit.spring.service.IFactureService;

@Scope(value = "session")
@Controller(value = "factureController")
@ELBeanName(value = "factureController")
@Join(path = "/", to = "/Facture.jsf")
@Named("factureController")// pour view
@ViewScoped
@RequestScoped
@ManagedBean
public class FactureControlImpl {
	@Autowired
	IFactureService factService;

	private Long nfacture;
	private Long Nfactupdate;
	private Long idClient;
	private String Nomclient;
	private double telephone;
	private int quantite;
	private String NB;
	private Date date_debut;
	private Date date_fin;
	Type_Prod type_produit;
	Paiement type_paiement;
	private String email;
	private boolean payer;
	private Facture facture;
	public List<Facture> factures;// ajouter le getter et le setter

	public Paiement[] getPaiements() {
		return Paiement.values();
	}

	public Type_Prod[] getType_Prods() {
		return Type_Prod.values();
	}// ajouter les getters et setters
		// ajouter fact

	public void addfacture() {
		factService.addFact(new Facture( idClient, Nomclient, telephone, quantite, NB, date_debut, date_fin,
				type_produit, type_paiement, email,payer));
	}

	/// toutes les factures
	public List<Facture> getFactures() {
		return factService.retrieveAllFact();
	}

	// supprimer
	public void removeFacture(String Nfacture) {
		factService.deleteFact(Nfacture);

	}

	// affichage
public void displayFacture(Facture fact){
	this.setIdClient(fact.getIdClient());
	this.setNomclient(fact.getNomclient());
	this.setTelephone(fact.getTelephone());
	this.setQuantite(fact.getQuantite());
	this.setNB(fact.getNB());
	this.setDate_debut(fact.getDate_debut());
	this.setDate_fin(fact.getDate_fin());
	this.setType_paiement(fact.getType_paiement());
	this.setType_produit(fact.getType_produit());
	this.setNfactupdate(fact.getNfacture());
	this.setEmail(fact.getEmail());
	this.setPayer(fact.getisPaiement());
	
}
/////mise a jour
public void UpdateFacture(){
	Facture fact=new Facture(Nfactupdate, idClient, Nomclient, telephone, quantite, NB, date_debut, date_fin,type_produit, type_paiement, email,payer);
	factService.updateFact(fact);
}
//// RECHERECHE BY CLIENTID
public void findbyidclient(Long clientid){
	factService.trouverfactclient(idClient);
}
	
	//// recherche by id facture
	public void findfacture (String Nfacture) {
		factService.retrieveFact(Nfacture);
	}


public void notification(){
factService.NotificationMail();	
//RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, " le notification est bien envoyer par email","ok"));
}



/// VIEW
public void onRowSelect(SelectEvent event) {
    FacesMessage msg = new FacesMessage("Facture Selected",String.valueOf(getFacture()));
    	
    FacesContext.getCurrentInstance().addMessage(null, msg);
}

public void onRowUnselect(UnselectEvent event) {
    FacesMessage msg = new FacesMessage("Facture Unselected",String.valueOf(getFacture()));
    FacesContext.getCurrentInstance().addMessage(null, msg);
}
//message
public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
    FacesContext.getCurrentInstance().
            addMessage(null, new FacesMessage(severity, summary, detail));
}

public void showInfo() {
    addMessage(FacesMessage.SEVERITY_INFO, "AJOUT", "la facture est bien ajoutée");
}
public void showInfosupp() {
    addMessage(FacesMessage.SEVERITY_INFO, "SUPPRIMER", "la facture est bien supprimée");
}
public void showInfomodifier() {
    addMessage(FacesMessage.SEVERITY_INFO, "MODIFIER", "la facture est bien modifiée");
}
public void showInfonotif() {
    addMessage(FacesMessage.SEVERITY_INFO, "NOTIFICATTION", "la notification est bien envoyée par mail au client");
}





/**
 * @return the nfacture
 */

public Long getNfactupdate() {
	return Nfactupdate;
}
/**
 * @return the nfacture
 */
public Long getNfacture() {
	return nfacture;
}

/**
 * @param nfacture the nfacture to set
 */
public void setNfacture(Long nfacture) {
	this.nfacture = nfacture;
}

public void setNfactupdate(Long nfactupdate) {
	Nfactupdate = nfactupdate;
}
public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNomclient() {
	return Nomclient;
}
public void setNomclient(String nomclient) {
	Nomclient = nomclient;
}
public double getTelephone() {
	return telephone;
}
public void setTelephone(double telephone) {
	this.telephone = telephone;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public String getNB() {
	return NB;
}
public void setNB(String nB) {
	NB = nB;
}
public Date getDate_debut() {
	return date_debut;
}
public void setDate_debut(Date date_debut) {
	this.date_debut = date_debut;
}
public Date getDate_fin() {
	return date_fin;
}
public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
}
public Type_Prod getType_produit() {
	return type_produit;
}
public void setType_produit(Type_Prod type_produit) {
	this.type_produit = type_produit;
}
public Paiement getType_paiement() {
	return type_paiement;
}


/**
 * @return the facture
 */
public Facture getFacture() {
	return facture;
}

/**
 * @param facture the facture to set
 */
public void setFacture(Facture facture) {
	this.facture = facture;
}

public void setType_paiement(Paiement type_paiement) {
	this.type_paiement = type_paiement;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public void setFactures(List<Facture> factures) {
	this.factures = factures;
}

/**
 * @return the payer
 */
public boolean isPayer() {
	return payer;
}

/**
 * @param payer the payer to set
 */
public void setPayer(boolean payer) {
	this.payer = payer;
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
pie.set("Agricole", factService.StatiqueAgricole());
pie.set("Sante", factService.StatiqueSante());
pie.set("Education", factService.StatiqueEducation());
pie.setTitle("statistiques des factures de chaque type de produits");
pie.setLegendPosition("e");

}

private void createBarModels() {
	createBarModel();
	createHorizontalBarModel();
	
}
private void createHorizontalBarModel() {
	horizontalBarModel=new HorizontalBarChartModel();
	ChartSeries Factures= new ChartSeries();
	Factures.setLabel("Factures");
	Factures.set(Factures, factService.nbreFactures());
	ChartSeries agricole= new ChartSeries();
	agricole.setLabel("agricole");
	agricole.set(agricole, factService.nbreFacturesAgricole());
	ChartSeries Sante= new ChartSeries();
	Sante.setLabel("Sante");
	Sante.set(Sante, factService.nbreFacturesSante());
	ChartSeries Education= new ChartSeries();
	Education.setLabel("Education");
	Education.set(Education, factService.nbreFacturesEducation());
	horizontalBarModel.addSeries(Factures);
	horizontalBarModel.addSeries(agricole);
	horizontalBarModel.addSeries(Sante);
	horizontalBarModel.addSeries(Education);
	horizontalBarModel.setTitle("nombre de factures de chaque type");
	horizontalBarModel.setLegendPosition("e");
	horizontalBarModel.setStacked(true);
	Axis xAxis=horizontalBarModel.getAxis(AxisType.X);
	xAxis.setLabel("nombres");
	xAxis.setMin(0);
	xAxis.setMax(2000);
	Axis yAxis=horizontalBarModel.getAxis(AxisType.Y);
	yAxis.setLabel("factures");
	
}
private void createBarModel() {
	barModel=initBarModel();
	barModel.setTitle("somme de montants de chaque produit");
	barModel.setLegendPosition("ne");
	Axis xAxis=barModel.getAxis(AxisType.X);
	xAxis.setLabel("factures");
	xAxis.setMin(0);
	xAxis.setMax(200);
	Axis yAxis=barModel.getAxis(AxisType.Y);
	yAxis.setLabel("sommes totales");
	yAxis.setMin(0);
	yAxis.setMax(2000);
	
	
	
}
private BarChartModel initBarModel() {
	BarChartModel model= new BarChartModel();
	ChartSeries Factures= new ChartSeries();
	Factures.setLabel("Factures");
	Factures.set(Factures, factService.SommeMontantFacture());
	ChartSeries agricole= new ChartSeries();
	agricole.setLabel("agricole");
	agricole.set(agricole, factService.SommeMontantFactureAgricole());

	ChartSeries Sante= new ChartSeries();
	Sante.setLabel("Sante");
	Sante.set(Sante, factService.SommeMontantFactureSante());
	
	ChartSeries Education= new ChartSeries();
	Education.setLabel("Education");
	Education.set(Education, factService.SommeMontantFactureEducation());


	
	model.addSeries(Factures);
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


}
