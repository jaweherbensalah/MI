package tn.mi.spring.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	private LocalDateTime date_debut;

	
	private LocalDateTime date_fin;
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

	public LocalDateTime getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDateTime getDate_fin() {
		return date_fin;
	}



	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
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



	
	

	




	

	public double getQuantite() {
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


	
	


	

	public Indemnisation() {
		super();
	}

		
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Indemnisation(Long num_ind, Long id, String nom, LocalDateTime date_debut, LocalDateTime date_fin, int quantite,
			Type_Prod type_produit, Virement virement, String email) {
		super();
		this.num_ind = num_ind;
		this.id = id;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.quantite = quantite;
		this.type_produit = type_produit;
		this.virement = virement;
		this.email = email;
	}

	public Indemnisation(Long id, String nom,LocalDateTime date_debut, LocalDateTime date_fin, int quantite, Type_Prod type_produit,
			Virement virement, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.quantite = quantite;
		this.type_produit = type_produit;
		this.virement = virement;
		this.email = email;
	}

	@Override
	public String toString() {
		return "indemnisation :[numero d indemnisation=" + num_ind + ",id de client =" + id + ", nom de client=" + nom + ", date de debut=" + date_debut + ", date fin="
				+ date_fin +",QUANTITE=" + quantite+",prix unitaire=" + prix_unitaire +",montant=" + montant + ",type de produit=" + type_produit + ",type de virement=" + virement + ",email=" + email + "]";
	}

}
