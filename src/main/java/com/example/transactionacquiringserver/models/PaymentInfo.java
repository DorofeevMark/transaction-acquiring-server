package com.example.transactionacquiringserver.models;

public class PaymentInfo {
    CardInfo card;
    int amount;
    String currency;
    String merchantId;

    public PaymentInfo(CardInfo card, int amount, String currency, String merchantId) {
        this.card = card;
        this.amount = amount;
        this.currency = currency;
        this.merchantId = merchantId;
    }

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
}
