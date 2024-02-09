package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name="formateur")
public class Formateur {
    @Id
    @Column(name = "CIN", nullable = false, unique = true)
    private String CIN;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "age", nullable = false)
    private int age;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "formation_formateur", 
        joinColumns = @JoinColumn(name = "formateur_CIN"), 
        inverseJoinColumns = @JoinColumn(name = "formation_id"))
    private List<Formation> formations;


    // Constructeur par défaut
    public Formateur() {
    }

    // Constructeur avec paramètres
    public Formateur(String CIN, String nom, int age) {
        this.CIN = CIN;
        this.nom = nom;
        this.age = age;
    }

    // Getters et setters
    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Formation> getFormations() {
    	 if (formations == null) {
             formations = new ArrayList<>();
         }
         return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }
}
