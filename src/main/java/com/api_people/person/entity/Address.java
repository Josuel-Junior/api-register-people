package com.api_people.person.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;


    private String street;
    private String city;
    private String zipCode;
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Address() {
    }

    public Address(String street, String city, String zipCode, Integer number, UUID id) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.number = number;
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
