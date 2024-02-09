package model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
@Entity
@Table(name="lieu")
public class Lieu implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@Column(name="idLieu",unique=true)
	 private int idLieu;
	@Column(name="adresse",nullable=false)
	 private String adresse;
	
	@Column(name="ville",nullable=false)
	 private String ville; 
	 
	public Lieu() {
		super();
	}
	public Lieu(String adresse, String ville) {
		super();
		this.adresse = adresse;
		this.ville = ville;
	}
	public int getId() {
		return idLieu;
	}
	public void setId(int id) {
		this.idLieu = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	

}
