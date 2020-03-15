package com.example.transactionacquiringserver.services;

import com.example.transactionacquiringserver.models.PaymentSystem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class PaymentSystemService {
    private static final ArrayList<PaymentSystem> services = new ArrayList<PaymentSystem>(Arrays.asList(
            new PaymentSystem("^2[0-9]{15}$", "Mir", "a"),
            new PaymentSystem("^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$", "Maestro", "a"),
            new PaymentSystem("^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$", "Mastercard", "a"),
            new PaymentSystem("^4[0-9]{12}(?:[0-9]{3})?$", "Visa", "a"),
            new PaymentSystem("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$", "Visa Master", "a"),
            new PaymentSystem("^(62[0-9]{14,17})$", "Union Pay", "a")
    ));

    public PaymentSystem getPaymentSystemByBIN(String bin) {
        for (PaymentSystem service : services) {
            if (bin.matches(service.getPatter())) {
                return service;
            }
        }
        return null;
    }
}
