package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "T_CUSTOMER")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long id;

	@Column(name = "CUSTOMER_PHONE")
	private String phone;

	@Column(name = "CUSTOMER_ADDRESS")
	private String address;

	@Temporal(TemporalType.DATE)
	private Date birth_date;

	@Column(name = "CUSTOMER_CNI_IMAGE")
	private String cni_image;

	@Column(name = "CUSTOMER_SIGN_IMAGE")
	private String sign_image;
	
	@Column(name = "CUSTOMER_MEDICAL_BOOKLET_IMAGE")
	private String medical_booklet_image;
	
	
	@Enumerated(EnumType.STRING)
	private Level level;
	
	@Enumerated(EnumType.STRING)
	private Experience experience;
	
	@Enumerated(EnumType.STRING)
	private Validity validity;

	public Customer() {
	}

	/**
	 * @param id
	 * @param phone
	 * @param address
	 * @param birth_date
	 * @param cni_image
	 * @param sign_image
	 * @param medical_booklet_image
	 * @param level
	 * @param experience
	 * @param validity
	 */
	public Customer(Long id, String phone, String address, Date birth_date, String cni_image, String sign_image,
			String medical_booklet_image, Level level, Experience experience, Validity validity) {
		super();
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.birth_date = birth_date;
		this.cni_image = cni_image;
		this.sign_image = sign_image;
		this.medical_booklet_image = medical_booklet_image;
		this.level = level;
		this.experience = experience;
		this.validity = validity;
	}

	/**
	 * @param phone
	 * @param address
	 * @param birth_date
	 * @param cni_image
	 * @param sign_image
	 * @param medical_booklet_image
	 * @param level
	 * @param experience
	 * @param validity
	 */
	public Customer(String phone, String address, Date birth_date, String cni_image, String sign_image,
			String medical_booklet_image, Level level, Experience experience, Validity validity) {
		super();
		this.phone = phone;
		this.address = address;
		this.birth_date = birth_date;
		this.cni_image = cni_image;
		this.sign_image = sign_image;
		this.medical_booklet_image = medical_booklet_image;
		this.level = level;
		this.experience = experience;
		this.validity = validity;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
