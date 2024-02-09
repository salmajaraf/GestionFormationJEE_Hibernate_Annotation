package model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="formation")
public class Formation implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Utilisez GenerationType.IDENTITY pour l'auto-incrémentation
	@Column(name = "id", unique = true, nullable = false)
	 private int id;
	@Column(name="theme",nullable=false)
	 private String theme;
	@ManyToOne
	@JoinColumn(name="reflieu")
	 private Lieu lieu; 
	@ManyToMany(mappedBy="formations")
	private List<Formateur> formateurs;
	
	
	 
	public Formation() {
		super();
	}
	public Formation(String theme, Lieu lieu) {
		super();
		this.theme = theme;
		this.lieu = lieu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu=lieu;
	}
	public int getLieuId() {
        if (lieu != null) {
            return lieu.getId();
        }
        return 0; // Ou une valeur qui représente l'absence d'un lieu
    }
	public void setLieuId(int idLieu) {
	    if (lieu == null) {
	        lieu = new Lieu();
	    }
	    lieu.setId(idLieu);
	}
	public List<Formateur> getFormateurs() {
		if (formateurs == null) {
            formateurs = new ArrayList<>();
        }
        return formateurs;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

	

}
