package com.example.chineseyear.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "chinese_year")
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "yearDate")
    private String yearDate;

    @ManyToOne
    @JoinColumn(name = "sign_id")
    private Sign sign;

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public Year() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYearDate() {
        return yearDate;
    }

    public void setYearDate(String yearDate) {
        this.yearDate = yearDate;
    }

    public Year(long id, String yearDate, Sign sign) {
        this.id = id;
        this.yearDate = yearDate;
        this.sign = sign;
    }
}