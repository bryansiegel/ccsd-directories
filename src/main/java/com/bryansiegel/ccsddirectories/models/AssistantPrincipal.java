package com.bryansiegel.ccsddirectories.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
public class AssistantPrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private SchoolTelephoneDirectory schoolTelephoneDirectory;

    @Version
    private Integer version;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AssistantPrincipal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolTelephoneDirectory=" + schoolTelephoneDirectory +
                ", version=" + version +
                '}';
    }
}