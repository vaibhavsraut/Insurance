package com.insurance.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a Premium.
 */
@Entity
public class Premium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private LocalDate premiumStartDate;
    private LocalDate premiumEndDate;
    private String premiumType;
    private Double price;

    // Constructors
    public Premium() {}

    public Premium(String userName, LocalDate premiumStartDate, LocalDate premiumEndDate, String premiumType, Double price) {
        this.userName = userName;
        this.premiumStartDate = premiumStartDate;
        this.premiumEndDate = premiumEndDate;
        this.premiumType = premiumType;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getPremiumStartDate() {
        return premiumStartDate;
    }

    public void setPremiumStartDate(LocalDate premiumStartDate) {
        this.premiumStartDate = premiumStartDate;
    }

    public LocalDate getPremiumEndDate() {
        return premiumEndDate;
    }

    public void setPremiumEndDate(LocalDate premiumEndDate) {
        this.premiumEndDate = premiumEndDate;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(String premiumType) {
        this.premiumType = premiumType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
