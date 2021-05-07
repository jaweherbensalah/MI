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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;




@Entity
@Table(name="Tab_track")

public class Track  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String description;	
	@Value("false")
	private boolean realised; 
	
	@Temporal(TemporalType.DATE)
	private Date date_begin;
	
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	@ManyToOne
	private Investigator investigator;
	@ManyToOne
	private Sinister sinister;

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Track(int id, String description, boolean realised, Date date_begin, Date deadline, Investigator investigator, Sinister sinister) {
		super();
		this.id = id;
		this.description = description;
		this.realised = realised;
		this.date_begin = date_begin;
		this.deadline = deadline;
		this.investigator = investigator;
		this.sinister = sinister;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRealised() {
		return realised;
	}

	public void setRealised(boolean realised) {
		this.realised = realised;
	}

	public Date getDate_begin() {
		return date_begin;
	}

	public void setDate_begin(Date date_begin) {
		this.date_begin = date_begin;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Investigator getInvestigator() {
		return investigator;
	}

	public void setInvestigator(Investigator investigator) {
		this.investigator = investigator;
	}

	public Sinister getSinister() {
		return sinister;
	}

	public void setSinister(Sinister sinister) {
		this.sinister = sinister;
	}

	


}
