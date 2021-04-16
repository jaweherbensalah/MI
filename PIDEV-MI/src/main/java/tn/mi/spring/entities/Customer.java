package tn.mi.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Customer extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String phone;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birth_date;

	private String cni_image;
	
	private String sign_image;
	
	private String medical_booklet_image;
	
	
	@Enumerated(EnumType.STRING)
	private Level level;
	
	@Enumerated(EnumType.STRING)
	private Experience experience;
	
	@Enumerated(EnumType.STRING)
	private Validity validity;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	List<Contract> contracts;

	public Customer() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param appUserRole
	 * @param phone
	 * @param address
	 * @param birth_date
	 * @param cni_image
	 * @param sign_image
	 * @param medical_booklet_image
	 * @param level
	 * @param experience
	 * @param validity
	 * @param contracts
	 */
	public Customer(String firstName, String lastName, String email,
			String phone, String address, Date birth_date, String cni_image, String sign_image,
			String medical_booklet_image, Level level, Experience experience, Validity validity,
			List<Contract> contracts) {
		super(firstName, lastName, email);
		this.phone = phone;
		this.address = address;
		this.birth_date = birth_date;
		this.cni_image = cni_image;
		this.sign_image = sign_image;
		this.medical_booklet_image = medical_booklet_image;
		this.level = level;
		this.experience = experience;
		this.validity = validity;
		this.contracts = contracts;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the birth_date
	 */
	public Date getBirth_date() {
		return birth_date;
	}

	/**
	 * @param birth_date the birth_date to set
	 */
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	/**
	 * @return the cni_image
	 */
	public String getCni_image() {
		return cni_image;
	}

	/**
	 * @param cni_image the cni_image to set
	 */
	public void setCni_image(String cni_image) {
		this.cni_image = cni_image;
	}

	/**
	 * @return the sign_image
	 */
	public String getSign_image() {
		return sign_image;
	}

	/**
	 * @param sign_image the sign_image to set
	 */
	public void setSign_image(String sign_image) {
		this.sign_image = sign_image;
	}

	/**
	 * @return the medical_booklet_image
	 */
	public String getMedical_booklet_image() {
		return medical_booklet_image;
	}

	/**
	 * @param medical_booklet_image the medical_booklet_image to set
	 */
	public void setMedical_booklet_image(String medical_booklet_image) {
		this.medical_booklet_image = medical_booklet_image;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the experience
	 */
	public Experience getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	/**
	 * @return the validity
	 */
	public Validity getValidity() {
		return validity;
	}

	/**
	 * @param validity the validity to set
	 */
	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	/**
	 * @return the contracts
	 */
	public List<Contract> getContracts() {
		return contracts;
	}

	/**
	 * @param contracts the contracts to set
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [phone=" + phone + ", address=" + address + ", birth_date=" + birth_date + ", cni_image="
				+ cni_image + ", sign_image=" + sign_image + ", medical_booklet_image=" + medical_booklet_image
				+ ", level=" + level + ", experience=" + experience + ", validity=" + validity + ", contracts="
				+ contracts + "]";
	}

	
	
	
}