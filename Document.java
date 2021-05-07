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




@Entity
@Table(name="Tab_document")

public class Document  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String description;	
	private String type;
	@ManyToOne
	private Sinister sinister;
	public Document() {
		super();
	}
	public Document(int id, String description, String type, Sinister sinister) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Sinister getSinister() {
		return sinister;
	}
	public void setSinister(Sinister sinister) {
		this.sinister = sinister;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
