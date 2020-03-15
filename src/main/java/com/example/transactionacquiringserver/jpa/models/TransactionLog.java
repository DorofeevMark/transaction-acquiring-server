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
}