package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="Tab_facture")

public class Facture  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Nfacture")
	private Long Nfacture;
	@Column(name="ID_client")
	private Long id;
	@Column(name="client")
	private String client; 
	
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@Column(name="paiement")
	private double paiement;
	@Column(name="type_produit")
	private String type_produit;
	@Enumerated(EnumType.STRING)
	Paiement type_paiement;


	@ManyToOne
	Contract Contrats;


	public Facture() {
		super();
	}


	public Facture(Long nfacture, Long id, String client, Date date_debut, Date date_fin, double paiement,
			String type_produit, Paiement type_paiement) {
		super();
		this.Nfacture = nfacture;
		this.id = id;
		this.client = client;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.paiement = paiement;
		this.type_produit = type_produit;
		this.type_paiement = type_paiement;
		
	}
	
	public Facture(Long nfacture, Long id, String client, Date date_debut, Date date_fin, double paiement,
			String type_produit, Paiement type_paiement, Contract contrats) {
		super();
		this.Nfacture = nfacture;
		this.id = id;
		this.client = client;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.paiement = paiement;
		this.type_produit = type_produit;
		this.type_paiement = type_paiement;
		Contrats = contrats;
	}


	@Override
	public String toString() {
		return "facture :[numero de facture=" + Nfacture + ",id de client =" + id + ", nom de client=" + client + ", date de debut=" + date_debut + ", date fin="
				+ date_fin +",prix de produit=" + paiement + ",type de produit=" + type_produit + ",type de paiement=" + type_paiement + "]";
	}

	


	public Long getNfacture() {
		return Nfacture;
	}


	public void setNfacture(Long nfacture) {
		Nfacture = nfacture;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
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


	public String getType_produit() {
		return type_produit;
	}


	public void setType_produit(String type_produit) {
		this.type_produit = type_produit;
	}


	public Paiement getType_paiement() {
		return type_paiement;
	}


	public void setType_paiement(Paiement type_paiement) {
		this.type_paiement = type_paiement;
	}


	public Contract getContrats() {
		return Contrats;
	}


	public void setContrats(Contract contrats) {
		Contrats = contrats;
	}


}
