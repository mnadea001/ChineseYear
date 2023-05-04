package com.example.chineseyear.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "prenom is mandatory")
    @Column(name = "prenom")
    private String prenom;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Adresse is mandatory")
    @Column(name = "adresse")
    private String adresse;

    @NotBlank(message = "Ville is mandatory")
    @Column(name = "ville")
    private String ville;

    @NotBlank(message = "Cp is mandatory")
    @Column(name = "cp")
    private String cp;

    @NotBlank(message = "Pays is mandatory")
    @Column(name = "pays")
    private String pays;

    @Column(name = "birthyear")
    private Integer birthyear;

    public User() {
    }

    public User(String name, String prenom, String email, String adresse, String ville, String cp, String pays, Integer birthyear) {
    }

    public User(Long id, String name, String prenom, String email, String adresse, String ville, String cp, @NotBlank(message = "Pays is mandatory") String pays, Integer birthyear) {
        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
        this.birthyear = birthyear;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", cp='" + cp + '\'' +
                ", pays='" + pays + '\'' +
                ", birthyear=" + birthyear +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }
}
