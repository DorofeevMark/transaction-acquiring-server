package com.example.transactionacquiringserver.jpa.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransactionLog {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String response;
    private Date date;

    @OneToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "id")
    private PaymentInfo paymentInfo;

    @OneToOne
    @JoinColumn(name = "paymentSystemId", referencedColumnName = "id")
    private PaymentSystem paymentSystem;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
}