package com.example.transactionacquiringserver.controllers;

import com.example.transactionacquiringserver.models.CardInfo;
import com.example.transactionacquiringserver.models.PaymentInfo;
import com.example.transactionacquiringserver.models.PaymentSystem;
import com.example.transactionacquiringserver.services.PaymentSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaymentController {
    @Autowired
    private PaymentSystemService paymentSystemService;

    @PostMapping(path = "/proceed", consumes = "application/json", produces = "application/json")
    public Map<String, String> payment(@RequestBody PaymentInfo paymentInfo) {
        return Collections.singletonMap("response", paymentSystemService.sendRequestToPaymentService(paymentInfo));
    }
}

