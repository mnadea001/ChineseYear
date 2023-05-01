package com.example.chineseyear.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Name is mandatory")
    private String prenom;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Email is mandatory")
    private String adresse;

    @NotBlank(message = "Email is mandatory")
    private String ville;

    @NotBlank(message = "Email is mandatory")
    private String cp;

    @NotBlank(message = "Email is mandatory")
    private String pays;

    @NotBlank(message = "Birthyear is mandatory")
    private Integer birthyear;
}
