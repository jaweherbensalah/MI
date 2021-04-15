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
@Table(name = "T_SERVICE")
public class Service implements Serializable {
	
private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name = "SERVICE_ID")
	private Long id; 
	
	@Column(name = "SERVICE_NAME")
	private String service_name; 
	
	@Column(name = "DESCRIP_SERVICE")
	private String descrip_service; 
	
	@ManyToOne
    private Formular formular;

	/**
	 * 
	 */
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(Long id, String service_name, String descrip_service, Formular formular) {
		super();
		this.id = id;
		this.service_name = service_name;
		this.descrip_service = descrip_service;
		this.formular = formular;
	}

	public Service(String service_name, String descrip_service, Formular formular) {
		super();
		this.service_name = service_name;
		this.descrip_service = descrip_service;
		this.formular = formular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getDescrip_service() {
		return descrip_service;
	}

	public void setDescrip_service(String descrip_service) {
		this.descrip_service = descrip_service;
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
		return "Service [id=" + id + ", service_name=" + service_name + ", descrip_service=" + descrip_service
				+ ", formular=" + formular + "]";
	} 
	

	
}
