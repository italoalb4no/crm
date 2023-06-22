package com.example.application.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "Addresses")
public class AddressEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(nullable = false, length = 20)
    private String country;
    @Column(nullable = false, length = 30)
    private String province;
    @Column(nullable = false, length = 30)
    private String region;
    @Column(nullable = false, length = 30)
    private String city;
    @Column(nullable = false, length = 50)
    private String firstAddressLine;
    @Column(length = 50)
    private String secondAddressLine;
    @Column(nullable = false, length = 50)
    private String zipCode;
    @Column(length = 255)
    private String additionalNotes;

    public AddressEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public AddressEntity(String id, String country, String province, String region, String city, String firstAddressLine, String secondAddressLine, String zipCode, String additionalNotes) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.region = region;
        this.city = city;
        this.firstAddressLine = firstAddressLine;
        this.secondAddressLine = secondAddressLine;
        this.zipCode = zipCode;
        this.additionalNotes = additionalNotes;
    }

    public AddressEntity(AddressEntity address) {
        this.id = address.id;
        this.country = address.country;
        this.province = address.province;
        this.region = address.region;
        this.city = address.city;
        this.firstAddressLine = address.firstAddressLine;
        this.secondAddressLine = address.secondAddressLine;
        this.zipCode = address.zipCode;
        this.additionalNotes = address.additionalNotes;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstAddressLine() {
        return this.firstAddressLine;
    }

    public void setFirstAddressLine(String firstAddressLine) {
        this.firstAddressLine = firstAddressLine;
    }

    public String getSecondAddressLine() {
        return this.secondAddressLine;
    }

    public void setSecondAddressLine(String secondAddressLine) {
        this.secondAddressLine = secondAddressLine;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAdditionalNotes() {
        return this.additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}