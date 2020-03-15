package com.example.transactionacquiringserver.services;

import com.example.transactionacquiringserver.jpa.models.TransactionLog;
import com.example.transactionacquiringserver.jpa.repositories.CardInfoRepository;
import com.example.transactionacquiringserver.jpa.repositories.PaymentInfoRepository;
import com.example.transactionacquiringserver.jpa.repositories.PaymentSystemRepository;
import com.example.transactionacquiringserver.jpa.repositories.TransactionLogRepository;
import com.example.transactionacquiringserver.jpa.models.PaymentInfo;
import com.example.transactionacquiringserver.jpa.models.PaymentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Service
public class PaymentSystemService {
    @Autowired
    private RestClientService restClientService;
    @Autowired
    private TransactionLogRepository transactionLogRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private CardInfoRepository cardInfoRepository;
    @Autowired
    private PaymentSystemRepository paymentSystemRepository;
    private ArrayList<PaymentSystem> services = new ArrayList<PaymentSystem>();

    public PaymentSystem getPaymentSystemByBIN(String bin) {
        services = (ArrayList<PaymentSystem>) paymentSystemRepository.findAll();
        for (PaymentSystem service : services) {
            if (bin.matches(service.getPatter())) {
                return service;
            }
        }
        return null;
    }

    public String sendRequestToPaymentService(PaymentInfo paymentInfo) {
        PaymentSystem paymentSystem = this.getPaymentSystemByBIN(paymentInfo.getCard().getBin());
        String response = this.restClientService.post(paymentSystem.getEndpoint(), "");

        cardInfoRepository.save(paymentInfo.getCard());
        paymentInfoRepository.save(paymentInfo);

        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setDate(new Date());
        transactionLog.setResponse(response);
        transactionLog.setPaymentInfo(paymentInfo);
        transactionLog.setPaymentSystem(paymentSystem);
        transactionLogRepository.save(transactionLog);
        return response;
    }
}
