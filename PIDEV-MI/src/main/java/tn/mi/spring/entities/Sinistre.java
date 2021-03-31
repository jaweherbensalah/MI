package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_SINISTRES")
public class Sinistre  implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="N_sinistre")
	private Long num;

	@Column(name="id_client")
	private Long id;
	@Column(name="nom")
	private String Firstname; 
	@Column(name="prenom")
	private String lastname ; 
	@Column(name="cin")
	private Long cin; 
	@Column(name="type_de_sinistre")
	private String type;
	
	@Temporal(TemporalType.DATE)
	private Date date_sinistre;
	
	@Temporal(TemporalType.DATE)
	private Date date_declaration;

	@Column(name="type_produit")
	private String type_produit;
	@Column(name="validation")
	private boolean valid;
	@Column(name="location_de_sinistre")
	private String location;

	@ManyToOne
	Indemnisation Indemnisations;
}
