package tn.mi.spring.entities;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;






@Entity
@Table(name="Tab_facture")
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
//@ToString
@Data
@NoArgsConstructor

@AllArgsConstructor
public class Facture  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Nfacture")
	private Long Nfacture;
	@Column(name="ID_client")
	private Long idClient;
	@Column(name="Nomclient")
	private String Nomclient;
	@Column(name="telephone",length=8)
	private double telephone;
	
	@Column(name="quantité")
	private int quantite; 
	@Column(name="prix_unitaire")
	private double prix_unitaire;
	@Column(name="Total_HT")
	private double Total_HT; 
	//Total_HT=prix*quantite
	@Column(name="TVA")
	private double TVA ;
	@Column(name="Total_TTC")
	private double Total_TTC; 
	//Total_HT+ Total_HT * TVA


	  
	@Column(name="NB")
	private String NB;
	
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@Column(name="type_produit")
	@Enumerated(EnumType.STRING)
	Type_Prod type_produit;
	@Enumerated(EnumType.STRING)
	Paiement type_paiement;
	
	
	@Column(name="reduction")
	private double reduction ;
	@Column(name="Total_reduction")
	private double Total_reduction ;
	@Column(name="EMail")
	private String email;
	
	//@OneToMany(mappedBy="facture",fetch=FetchType.LAZY)
	//private Collection<ReductionFacture> reductions;

	//@JoinColumn(name="CODE_CLIENT")
	//@Nullable
	//@NotFound(action = NotFoundAction.IGNORE)
	//private Client client;

	@ManyToOne
	Contract Contrats;


	public Facture() {
		super();
	}





	public double getTelephone() {
		return telephone;
	}





	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}





	/**
	 * @return the reduction
	 */
	public double getReduction() {
		return reduction;
	}





	/**
	 * @param reduction the reduction to set
	 */
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}





	public double getTotal_HT() {
		return Total_HT;
	}
	public void setTotal_HT(double total_HT) {
		Total_HT = total_HT;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(double prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public double getTotal_TTC() {
		return Total_TTC;
	}
	public void setTotal_TTC(double total_TTC) {
		Total_TTC = total_TTC;
	}

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

   public String getNB() {
		return NB;
	}

	public void setNB(String nB) {
		NB = nB;
	}
	

public Facture(Long nfacture, Long idClient, String nomclient, double telephone, int quantite, double prix_unitaire,
			 double tVA, String nB, Date date_debut,Date date_fin,
			Type_Prod type_produit, Paiement type_paiement, double reduction,String mail) {
		super();
		this.Nfacture = nfacture;
		this.idClient = idClient;
		Nomclient = nomclient;
		this.telephone = telephone;
		this.quantite = quantite;
		this.prix_unitaire = prix_unitaire;
		//this.Total_HT = prix_unitaire*quantite;
		TVA = tVA;
		//this.Total_TTC = this.Total_HT +(this.Total_HT * TVA);
		this.NB = nB;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type_produit = type_produit;
		this.type_paiement = type_paiement;
		this.reduction = reduction;
		this.email=mail;
		
	}









	public Facture(Long idClient, String nomclient, double telephone, int quantite, double tVA, String nB,
		Date date_debut, Date date_fin, Type_Prod type_produit, Paiement type_paiement,double reduction,
		String email) {
	super();
	this.idClient = idClient;
	Nomclient = nomclient;
	this.telephone = telephone;
	this.quantite = quantite;
	TVA = tVA;
	NB = nB;
	this.date_debut = date_debut;
	this.date_fin = date_fin;
	this.type_produit = type_produit;
	this.type_paiement = type_paiement;
	this.reduction=reduction;
	this.email = email;
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

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}





	@Override
	public String toString() {
		return "facture :[numero de facture=" + Nfacture + ",id de client =" + idClient + ", nom de client=" + Nomclient + ", date de debut=" + date_debut + ", date fin="
				+ date_fin +",numero de telephone de client=" +telephone +",quantite du produit="+quantite+",prix unitaire="+prix_unitaire+",prix de produit sans tva=" +Total_HT+",tva ="+TVA+",notez bien que="+NB+",prix de produit avec tva="+Total_TTC+",reduction avec des conditions bien precis="+reduction +",montant avec reduction valeur final="+Total_reduction + ",type de produit=" + type_produit + ",type de paiement=" + type_paiement + "]";
	}

	


	public Long getNfacture() {
		return Nfacture;
	}
	public void setNfacture(Long nfacture) {
		Nfacture = nfacture;
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





	public Type_Prod  getType_produit() {
		return type_produit;
	}
	public void setType_produit(Type_Prod  type_produit) {
		this.type_produit = type_produit;
	}
	public Paiement getType_paiement() {
		return type_paiement;
	}
	public void setType_paiement(Paiement type_paiement) {
		this.type_paiement = type_paiement;
	}

	public double getTotal_reduction() {
		return Total_reduction;
	}

	public double setTotal_reduction(double total_reduction) {
		return Total_reduction = total_reduction;
	}





	/*public Contrat getContrats() {
		return Contrats;
	}


	public void setContrats(Contrat contrats) {
		Contrats = contrats;
	}*/



}
