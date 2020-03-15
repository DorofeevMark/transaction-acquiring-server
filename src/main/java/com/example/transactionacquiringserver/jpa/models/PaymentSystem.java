package com.example.transactionacquiringserver.models;

public class PaymentSystem {
    String patter;
    String name;
    String endpoint;

    public PaymentSystem(String patter, String name, String endpoint) {
        this.patter = patter;
        this.name = name;
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getName() {
        return name;
    }

    public String getPatter() {
        return patter;
    }
}
