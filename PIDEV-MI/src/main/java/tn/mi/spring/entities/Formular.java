package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_FORMULAR")
public class Formular implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORMULAR_ID")
	private Long id;
	
	@Column(name = "FORMULAR_NAME")
	private String name;
	
	
	public Formular() {
	}

	/**
	 * @param id
	 * @param name
	 * @param contracts
	 */
	public Formular(Long id, String name, Set<Contract> contracts) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @param name
	 * @param contracts
	 */
	public Formular(String name, Set<Contract> contracts) {
		super();
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

