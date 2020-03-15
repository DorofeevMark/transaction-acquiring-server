package com.example.transactionacquiringserver.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentSystem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String patter;
    private String name;
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

    public String getName() {
        return name;
    }

    public String getPatter() {
        return patter;
    }

    public Integer getId() {
        return id;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatter(String patter) {
        this.patter = patter;
    }
}
