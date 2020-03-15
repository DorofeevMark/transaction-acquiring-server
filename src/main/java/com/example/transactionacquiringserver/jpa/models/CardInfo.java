package com.example.transactionacquiringserver.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardInfo {
    @Id
    private String bin;
    private String cardholderName;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;

    public String getBin() {
        return bin;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
}
