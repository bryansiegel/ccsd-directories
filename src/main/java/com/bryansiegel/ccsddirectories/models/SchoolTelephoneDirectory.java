package com.bryansiegel.ccsddirectories.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SchoolTelephoneDirectory {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private int location;
    private String grades;
    private String schoolName;
    private String schoolAddress;
    private String schoolTelephoneNumber;
    private String assistantPrincipal;
    private String schoolWan;
    private String schoolFax;
    private String schoolPrincipal;
    private String officeManager;
    private String trusteeDisctrict;
    private String municipality;
    private String regionUnitSupervisor;
    private String regionUnitSupervisorTelephoneNumber;
    private String studentSuccessCoordinator;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolTelephoneNumber() {
        return schoolTelephoneNumber;
    }

    public void setSchoolTelephoneNumber(String schoolTelephoneNumber) {
        this.schoolTelephoneNumber = schoolTelephoneNumber;
    }

    public String getSchoolWan() {
        return schoolWan;
    }

    public void setSchoolWan(String schoolWan) {
        this.schoolWan = schoolWan;
    }

    public String getSchoolFax() {
        return schoolFax;
    }

    public void setSchoolFax(String schoolFax) {
        this.schoolFax = schoolFax;
    }

    public String getSchoolPrincipal() {
        return schoolPrincipal;
    }

    public void setSchoolPrincipal(String schoolPrincipal) {
        this.schoolPrincipal = schoolPrincipal;
    }

    public String getOfficeManager() {
        return officeManager;
    }

    public void setOfficeManager(String officeManager) {
        this.officeManager = officeManager;
    }

    public String getTrusteeDisctrict() {
        return trusteeDisctrict;
    }

    public void setTrusteeDisctrict(String trusteeDisctrict) {
        this.trusteeDisctrict = trusteeDisctrict;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getRegionUnitSupervisor() {
        return regionUnitSupervisor;
    }

    public void setRegionUnitSupervisor(String regionUnitSupervisor) {
        this.regionUnitSupervisor = regionUnitSupervisor;
    }

    public String getRegionUnitSupervisorTelephoneNumber() {
        return regionUnitSupervisorTelephoneNumber;
    }

    public void setRegionUnitSupervisorTelephoneNumber(String regionUnitSupervisorTelephoneNumber) {
        this.regionUnitSupervisorTelephoneNumber = regionUnitSupervisorTelephoneNumber;
    }

    public String getStudentSuccessCoordinator() {
        return studentSuccessCoordinator;
    }

    public void setStudentSuccessCoordinator(String studentSuccessCoordinator) {
        this.studentSuccessCoordinator = studentSuccessCoordinator;
    }

    public String getAssistantPrincipal() {
        return assistantPrincipal;
    }

    public void setAssistantPrincipal(String assistantPrincipal) {
        this.assistantPrincipal = assistantPrincipal;
    }

    @Override
    public String toString() {
        return "SchoolTelephoneDirectory{" +
                "id=" + id +
                ", location=" + location +
                ", grades='" + grades + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", schoolTelephoneNumber='" + schoolTelephoneNumber + '\'' +
                ", assistantPrincipal='" + assistantPrincipal + '\'' +
                ", schoolWan='" + schoolWan + '\'' +
                ", schoolFax='" + schoolFax + '\'' +
                ", schoolPrincipal='" + schoolPrincipal + '\'' +
                ", officeManager='" + officeManager + '\'' +
                ", trusteeDisctrict='" + trusteeDisctrict + '\'' +
                ", municipality='" + municipality + '\'' +
                ", regionUnitSupervisor='" + regionUnitSupervisor + '\'' +
                ", regionUnitSupervisorTelephoneNumber='" + regionUnitSupervisorTelephoneNumber + '\'' +
                ", studentSuccessCoordinator='" + studentSuccessCoordinator + '\'' +
                '}';
    }
}