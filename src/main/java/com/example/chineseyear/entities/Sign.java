package com.example.chineseyear.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "chinese_sign")
public class Sign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;

    public Sign(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sign() {
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
}
