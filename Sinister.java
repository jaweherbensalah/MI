package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name="Tab_sinister")

public class Sinister  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String type;	
	private String location;
	@Value("false")
	private boolean validate = false;
	@Temporal(TemporalType.DATE)
	private Date date_sinister;
	
	@Temporal(TemporalType.DATE)
	private Date date_declaration;
	
	@OneToMany
	private List<Document> documents;
	@OneToMany
	private List<Track> tracks;
	@OneToMany
	private List<Witness> witnesses;
	
	public Sinister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sinister(int id, String type, String location, boolean validate, Date date_sinister, Date date_declaration,
			List<Document> documents, List<Track> tracks, List<Witness> witnesses) {
		super();
		this.id = id;
		this.type = type;
		this.location = location;
		this.validate = validate;
		this.date_sinister = date_sinister;
		this.date_declaration = date_declaration;
		this.documents = documents;
		this.tracks = tracks;
		this.witnesses = witnesses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public Date getDate_sinister() {
		return date_sinister;
	}

	public void setDate_sinister(Date date_sinister) {
		this.date_sinister = date_sinister;
	}

	public Date getDate_declaration() {
		return date_declaration;
	}

	public void setDate_declaration(Date date_declaration) {
		this.date_declaration = date_declaration;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Witness> getWitnesses() {
		return witnesses;
	}

	public void setWitnesses(List<Witness> witnesses) {
		this.witnesses = witnesses;
	}

	


}
