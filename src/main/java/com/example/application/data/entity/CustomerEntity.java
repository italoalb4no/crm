package com.example.application.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;
    @Column()
    private LocalDate creationDate;
    @Column()
    private LocalDate dateOfBirth;
    @Column()
    private boolean privateCustomer;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(length = 30)
    private String landlineNumber;
    @Column(length = 30)
    private String fiscalCode;
    @Column(length = 40)
    private String vatNumber;
    @Column(nullable = false, length = 30)
    private String mobileNumber;
    @Column(length = 40)
    private String userName;
    @Column(length = 60)
    private String encryptedPassword;
    @JoinColumn(name = "DOMICILE_ID", referencedColumnName = "id")
    @ManyToOne(targetEntity = AddressEntity.class)
    //(type = "uuid-char")
    private AddressEntity domicile;

    @JoinColumn(name = "RESIDENCE_ID", referencedColumnName = "id")
    @ManyToOne(targetEntity = AddressEntity.class)
    private AddressEntity residence;

    public CustomerEntity() {
        // this.id = UUID.fromString(LocalDateTime.now().toString());
        this.id = UUID.randomUUID();
    }

    public CustomerEntity(UUID id, LocalDate creationDate, LocalDate dateOfBirth, boolean privateCustomer, String firstName, String lastName, String email, String landlineNumber, String fiscalCode, String vatNumber, String mobileNumber, String userName, String encryptedPassword, AddressEntity domicile, AddressEntity residence) {
        this.id = id;
        this.creationDate = creationDate;
        this.dateOfBirth = dateOfBirth;
        this.privateCustomer = privateCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.landlineNumber = landlineNumber;
        this.fiscalCode = fiscalCode;
        this.vatNumber = vatNumber;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.domicile = domicile;
        this.residence = residence;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isPrivateCustomer() {
        return this.privateCustomer;
    }

    public void setPrivateCustomer(boolean privateCustomer) {
        this.privateCustomer = privateCustomer;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandlineNumber() {
        return this.landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public String getFiscalCode() {
        return this.fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getVatNumber() {
        return this.vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public AddressEntity getDomicile() {
        return this.domicile;
    }

    public void setDomicile(AddressEntity domicile) {
        this.domicile = domicile;
    }

    public AddressEntity getResidence() {
        return this.residence;
    }

    public void setResidence(AddressEntity residence) {
        this.residence = residence;
    }
}
