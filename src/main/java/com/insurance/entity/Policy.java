package com.insurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * Entity class representing a Policy.
 */
@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;

    private String policyNumber;
    private Double premium;
    private LocalDate startDate;
    private LocalDate endDate;

    // Constructors
    public Policy() {}

    public Policy(String policyNumber, Double premium, LocalDate startDate, LocalDate endDate) {
        this.policyNumber = policyNumber;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
