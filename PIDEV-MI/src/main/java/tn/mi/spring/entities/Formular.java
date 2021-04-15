package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "T_FORMULAR")
public class Formular implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name = "FORMULAR_ID")
	private Long id; 
	
	@Column(name = "FORMULAR_NAME")
	private String formular_name; 
	
	@Column(name = "PREMIUM_FORMULAR")
	private double premium_formular; 
	
	@Column(name = "COMPENSATION_FORMULAR")
	private double compensation_formular; 
	
	@Column(name = "CONDITION_FORMULAR")
	private String condition_formular; 
	
	@ManyToOne
    private Product product;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="formular")
	private Set<Service> services;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="formular")
	private Set<Risk> risks;

	
	public Formular() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formular(Long id, String formular_name, double premium_formular, double compensation_formular,
			String condition_formular, Product product, Set<Service> services, Set<Risk> risks) {
		super();
		this.id = id;
		this.formular_name = formular_name;
		this.premium_formular = premium_formular;
		this.compensation_formular = compensation_formular;
		this.condition_formular = condition_formular;
		this.product = product;
		this.services = services;
		this.risks = risks;
	}

	public Formular(String formular_name, double premium_formular, double compensation_formular,
			String condition_formular, Product product, Set<Service> services, Set<Risk> risks) {
		super();
		this.formular_name = formular_name;
		this.premium_formular = premium_formular;
		this.compensation_formular = compensation_formular;
		this.condition_formular = condition_formular;
		this.product = product;
		this.services = services;
		this.risks = risks;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFormular_name() {
		return formular_name;
	}


	public void setFormular_name(String formular_name) {
		this.formular_name = formular_name;
	}


	public double getPremium_formular() {
		return premium_formular;
	}


	public void setPremium_formular(double premium_formular) {
		this.premium_formular = premium_formular;
	}


	public double getCompensation_formular() {
		return compensation_formular;
	}


	public void setCompensation_formular(double compensation_formular) {
		this.compensation_formular = compensation_formular;
	}


	public String getCondition_formular() {
		return condition_formular;
	}


	public void setCondition_formular(String condition_formular) {
		this.condition_formular = condition_formular;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Set<Service> getServices() {
		return services;
	}


	public void setServices(Set<Service> services) {
		this.services = services;
	}


	public Set<Risk> getRisks() {
		return risks;
	}


	public void setRisks(Set<Risk> risks) {
		this.risks = risks;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Formular [id=" + id + ", formular_name=" + formular_name + ", premium_formular=" + premium_formular
				+ ", compensation_formular=" + compensation_formular + ", condition_formular=" + condition_formular
				+ ", product=" + product + ", services=" + services + ", risks=" + risks + "]";
	}


	
	
}
