package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name="montant")
	private double montant; 
	@Column(name="type_produit")
	private String type_produit;
	@Enumerated(EnumType.STRING)
	Virement virement;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="Indemnisations")
    private Set<Sinistre> Sinistres;
	public Long getNum_ind() {
		return num_ind;
	}

	public void setNum_ind(Long num_ind) {
		this.num_ind = num_ind;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getType_produit() {
		return type_produit;
	}

	public void setType_produit(String type_produit) {
		this.type_produit = type_produit;
	}

	public Set<Sinistre> getSinistres() {
		return Sinistres;
	}

	public void setSinistres(Set<Sinistre> sinistres) {
		Sinistres = sinistres;
	}

	
	
	public Indemnisation() {
		super();
	}

	public Indemnisation(Long num_ind, Long id, String nom, Date date_debut, Date date_fin, double montant,
			String type_produit, Virement virement) {
		super();
		this.num_ind = num_ind;
		this.id = id;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.montant = montant;
		this.type_produit = type_produit;
		this.virement = virement;
		
	}
	@Override
	public String toString() {
		return "indemnisation :[numero d indemnisation=" + num_ind + ",id de client =" + id + ", nom de client=" + nom + ", date de debut=" + date_debut + ", date fin="
				+ date_fin +",montant=" + montant + ",type de produit=" + type_produit + ",type de virement=" + virement + "]";
	}

}
