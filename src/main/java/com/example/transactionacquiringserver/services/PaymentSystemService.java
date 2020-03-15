package com.example.transactionacquiringserver.services;

import com.example.transactionacquiringserver.jpa.models.CardInfo;
import com.example.transactionacquiringserver.jpa.models.TransactionLog;
import com.example.transactionacquiringserver.jpa.repositories.CardInfoRepository;
import com.example.transactionacquiringserver.jpa.repositories.PaymentInfoRepository;
import com.example.transactionacquiringserver.jpa.repositories.TransactionLogRepository;
import com.example.transactionacquiringserver.jpa.models.PaymentInfo;
import com.example.transactionacquiringserver.models.PaymentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Service
public class PaymentSystemService {
    private static final ArrayList<PaymentSystem> services = new ArrayList<PaymentSystem>(Arrays.asList(
            new PaymentSystem("^2[0-9]{15}$", "Mir", "https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment"),
            new PaymentSystem("^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$", "Maestro", "https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment"),
            new PaymentSystem("^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$", "Mastercard", "https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment"),
            new PaymentSystem("^4[0-9]{12}(?:[0-9]{3})?$", "Visa", "https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment"),
            new PaymentSystem("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$", "Visa Master", "https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment"),
            new PaymentSystem("^(62[0-9]{14,17})$", "Union Pay", "https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment")
    ));
    @Autowired
    private RestClientService restClientService;
    @Autowired
    private TransactionLogRepository transactionLogRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private CardInfoRepository cardInfoRepository;

    public PaymentSystem getPaymentSystemByBIN(String bin) {
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
        transactionLogRepository.save(transactionLog);
        return response;
    }
}
