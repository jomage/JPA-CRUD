package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personne {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Solution 1
    @Column(length = 64, nullable = false)
    private String nom;
    
    // Solution 2
    @Column(columnDefinition = "varchar(64) NOT NULL")
    private String prenom;
    
    private String telephone;
    
    @Enumerated(EnumType.STRING)
    private Genre genre;
    
    private LocalDate dateNaissance;
    
    private Boolean actif = true;

    /**
     * Constructeur par défaut (requis par JPA si on définit un constructeur
     * personnalisé)
     */
    public Personne() {
        super();
    }

    /**
     * Constructeur personnalisé
     * @param nom le nom de la personne
     * @param prenom le prénom de la personne
     * @param genre le genre de la personne
     */
    public Personne(String nom, String prenom, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
    }
    
    // ToString

    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", genre="
                + genre + "]";
    }
    
    // Getters & Setters ----------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    
}
