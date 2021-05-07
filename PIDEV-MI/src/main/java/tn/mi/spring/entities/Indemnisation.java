package tn.mi.spring.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "T_indemnisation")
public class Indemnisation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="N_indemnisation")
	private Long num_ind;

	@Column(name="ID_client")
	private Long id;
	@Column(name="nom_client")
	private String nom;

	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@Column(name="Quantite")
	private int quantite;
	@Column(name="prix_unitaire")
	private double prix_unitaire;
	@Column(name="montant")
	private double montant; 
	@Column(name="type_produit")
	@Enumerated(EnumType.STRING)
	Type_Prod  type_produit;
	@Enumerated(EnumType.STRING)
	SANTE sante;
	@Enumerated(EnumType.STRING)
	REGION region;
	@Enumerated(EnumType.STRING)
	Virement virement;
	@Column(name="EMail")
	private String email;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="Indemnisations", 
			fetch=FetchType.EAGER)
    private Set<Sinistre> Sinistres;
	public Long getNum_ind() {
		return num_ind;
	}

	public void setNum_ind(Long num_ind) {
		this.num_ind = num_ind;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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

	public double getMontant() {
		return montant;
	}

	public double setMontant(double montant) {
		return this.montant = montant;
	}

	public Type_Prod getType_produit() {
		return type_produit;
	}

	public void setType_produit(Type_Prod type_produit) {
		this.type_produit = type_produit;
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix_unitaire() {
		return prix_unitaire;
	}

	public double setPrix_unitaire(double prix_unitaire) {
		return this.prix_unitaire = prix_unitaire;
	}

	public Virement getVirement() {
		return virement;
	}

	public void setVirement(Virement virement) {
		this.virement = virement;
	}


	@Override
	public boolean equals(Object obj) {
	
		Indemnisation other = (Indemnisation) obj;
		if (type_produit != other.type_produit) {
			return false;
		}
		
		return true;
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

	public Indemnisation() {
		super();
	}

		
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Indemnisation(Long num_indupdate, Long id, String nom, Date date_debut, Date date_fin, int quantite,
			Type_Prod type_produit,SANTE sante,REGION region, Virement virement, String email) {
		super();
		this.num_ind = num_indupdate;
		this.id = id;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.quantite = quantite;
		this.type_produit = type_produit;
		this.sante=sante;
		this.region=region;
		this.virement = virement;
		this.email = email;
	}

	public Indemnisation(Long id, String nom,Date date_debut, Date date_fin, int quantite, Type_Prod type_produit,SANTE sante,REGION region,
			Virement virement, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.quantite = quantite;
		this.type_produit = type_produit;
		this.sante=sante;
		this.region=region;
		this.virement = virement;
		this.email = email;
	}

	@Override
	public String toString() {
		return "indemnisation :[numero d indemnisation=" + num_ind + ",id de client =" + id + ", nom de client=" + nom + ", date de debut=" + date_debut + ", date fin="
				+ date_fin +",QUANTITE=" + quantite+",prix unitaire=" + prix_unitaire +",montant=" + montant + ",type de produit=" + type_produit + ",type de virement=" + virement + ",email=" + email + "]";
	}

}
