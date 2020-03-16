package com.example.transactionacquiringserver.jpa.models;

import javax.persistence.*;

@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cardId", referencedColumnName = "bin")
    CardInfo card;
    int amount;
    String currency;
    String merchantId;

    public CardInfo getCard() {
        return card;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCard(CardInfo card) {
        this.card = card;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id + "," +
                "\"card\": " + card + "," +
                "\"amount\": " + amount + "," +
                "\"currency\": " + '"' + currency + '"' + "," +
                "\"merchantId\": " + '"' + merchantId + '"' +
                '}';
    }
}
