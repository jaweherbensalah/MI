package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name = "PRODUCT_ID")
	private int id; 
	
	private Role role; 
	
	@Column(name = "PRODUCT_NAME")
	private String product_name; 
	
	@Column(name = "FEATURE")
	private String feature;
	
	@Column(name = "PRODUCT_PRICE")
	private double product_price; 
	
	@Column(name = "CREATION_DATE")
	private Date creation_date; 

	@OneToMany(cascade = CascadeType.ALL, mappedBy ="product")
	private Set<Formular> formulars;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, Role role, String product_name, String feature, double product_price, Date creation_date,
			Set<Formular> formulars) {
		super();
		this.id = id;
		this.role = role;
		this.product_name = product_name;
		this.feature = feature;
		this.product_price = product_price;
		this.creation_date = creation_date;
		this.formulars = formulars;
	}

	public Product(Role role, String product_name, String feature, double product_price, Date creation_date,
			Set<Formular> formulars) {
		super();
		this.role = role;
		this.product_name = product_name;
		this.feature = feature;
		this.product_price = product_price;
		this.creation_date = creation_date;
		this.formulars = formulars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Set<Formular> getFormulars() {
		return formulars;
	}

	public void setFormulars(Set<Formular> formulars) {
		this.formulars = formulars;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", role=" + role + ", product_name=" + product_name + ", feature=" + feature
				+ ", product_price=" + product_price + ", creation_date=" + creation_date + ", formulars=" + formulars
				+ "]";
	}


	
}	
	