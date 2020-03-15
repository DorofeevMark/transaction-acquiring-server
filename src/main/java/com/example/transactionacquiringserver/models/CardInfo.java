package com.example.transactionacquiringserver.models;

public class CardInfo {
    String bin;
    String cardholderName;
    String expirationMonth;
    String expirationYear;
    String cvv;

    public CardInfo(String bin, String cardholderName, String expirationMonth, String expirationYear, String cvv) {
        this.bin = bin;
        this.cardholderName = cardholderName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvv = cvv;
    }

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
}
