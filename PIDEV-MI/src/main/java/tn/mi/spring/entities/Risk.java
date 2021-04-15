package tn.mi.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "T_RISK")
public class Risk implements Serializable {

	
private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name = "RISK_ID")
	private Long id; 
	
	@Column(name = "TYPE_RISK")
	private String type_risk; 
	
	@Column(name = "DESCRIP_RISK")
	private String descrip_risk; 
	
	@ManyToOne
    private Formular formular;

	/**
	 * 
	 */
	public Risk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Risk(Long id, String type_risk, String descrip_risk, Formular formular) {
		super();
		this.id = id;
		this.type_risk = type_risk;
		this.descrip_risk = descrip_risk;
		this.formular = formular;
	}

	public Risk(String type_risk, String descrip_risk, Formular formular) {
		super();
		this.type_risk = type_risk;
		this.descrip_risk = descrip_risk;
		this.formular = formular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType_risk() {
		return type_risk;
	}

	public void setType_risk(String type_risk) {
		this.type_risk = type_risk;
	}

	public String getDescrip_risk() {
		return descrip_risk;
	}

	public void setDescrip_risk(String descrip_risk) {
		this.descrip_risk = descrip_risk;
	}

	public Formular getFormular() {
		return formular;
	}

	public void setFormular(Formular formular) {
		this.formular = formular;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Risk [id=" + id + ", type_risk=" + type_risk + ", descrip_risk=" + descrip_risk + ", formular="
				+ formular + "]";
	} 
	
	
}
