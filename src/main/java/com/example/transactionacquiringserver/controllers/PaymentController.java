package com.example.transactionacquiringserver.controllers;

import com.example.transactionacquiringserver.jpa.models.PaymentInfo;
import com.example.transactionacquiringserver.jpa.models.TransactionLog;
import com.example.transactionacquiringserver.jpa.repositories.TransactionLogRepository;
import com.example.transactionacquiringserver.services.PaymentSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaymentController {
    @Autowired
    private PaymentSystemService paymentSystemService;
    @Autowired
    private TransactionLogRepository transactionLogRepository;

    @PostMapping(path = "/proceed", consumes = "application/json", produces = "application/json")
    public Map<String, String> payment(@RequestBody PaymentInfo paymentInfo) {
        return Collections.singletonMap("response", paymentSystemService.sendRequestToPaymentService(paymentInfo));
    }

    @GetMapping(path="/getLogs")
    public @ResponseBody Iterable<TransactionLog> getAllLogs() {
        return transactionLogRepository.findAll();
    }
}

