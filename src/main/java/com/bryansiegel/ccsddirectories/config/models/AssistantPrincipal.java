package com.bryansiegel.ccsddirectories.config.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AssistantPrincipal {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    private SchoolTelephoneDirectory schoolTelephoneDirectory;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public SchoolTelephoneDirectory getSchoolTelephoneDirectory() {
        return schoolTelephoneDirectory;
    }

    public void setSchoolTelephoneDirectory(SchoolTelephoneDirectory schoolTelephoneDirectory) {
        this.schoolTelephoneDirectory = schoolTelephoneDirectory;
    }

    @Override
    public String toString() {
        return "AssistantPrincipal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolTelephoneDirectory=" + schoolTelephoneDirectory +
                '}';
    }
}