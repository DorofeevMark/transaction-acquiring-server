package com.example.transactionacquiringserver;

import com.example.transactionacquiringserver.controllers.PaymentController;
import com.example.transactionacquiringserver.jpa.models.CardInfo;
import com.example.transactionacquiringserver.jpa.models.PaymentInfo;
import com.example.transactionacquiringserver.jpa.repositories.TransactionLogRepository;
import com.example.transactionacquiringserver.services.PaymentSystemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private PaymentSystemService paymentSystemService;
    @MockBean
    private TransactionLogRepository transactionLogRepository;

    @Test
    public void testExample() throws Exception {
        CardInfo cardInfo = new CardInfo();
        cardInfo.setBin("412323232323");
        cardInfo.setCardholderName("Mark");
        cardInfo.setCvv("123");
        cardInfo.setExpirationMonth("12");
        cardInfo.setExpirationYear("21");

        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCard(cardInfo);
        paymentInfo.setAmount(12);
        paymentInfo.setCurrency("USD");
        paymentInfo.setMerchantId("SADASD");

        this.mvc.perform(post("/proceed")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(paymentInfo)))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}