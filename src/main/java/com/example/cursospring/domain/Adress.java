package com.example.cursospring.domain;

import java.io.Serializable;

public class Adress implements Serializable {
    private Integer id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String postlCode;

    private Client client;

    private City city;


    public Adress() {
    }

    public Adress(Integer id, String street, String number, String complement, String neighborhood, String postlCode, Client client, City city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.postlCode = postlCode;
        this.client = client;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPostlCode() {
        return postlCode;
    }

    public void setPostlCode(String postlCode) {
        this.postlCode = postlCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
