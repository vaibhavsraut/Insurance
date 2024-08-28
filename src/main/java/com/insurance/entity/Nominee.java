package com.insurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Entity class representing a Nominee.
 */
@Entity
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nomineeId;

    @ManyToOne
    private User user;

    private String name;
    private String relationship;
    private Double percentage;

    // Constructors
    public Nominee() {}

    public Nominee(User user, String name, String relationship, Double percentage) {
        this.user = user;
        this.name = name;
        this.relationship = relationship;
        this.percentage = percentage;
    }

    // Getters and Setters
    public Long getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(Long nomineeId) {
        this.nomineeId = nomineeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
