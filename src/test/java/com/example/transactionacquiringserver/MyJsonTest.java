package com.example.transactionacquiringserver;

import com.example.transactionacquiringserver.jpa.models.CardInfo;
import com.example.transactionacquiringserver.jpa.models.PaymentInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class MyJsonTest {

    @Autowired
    private JacksonTester<PaymentInfo> paymentJson;
    @Autowired
    private JacksonTester<CardInfo> cardJson;

    @Test
    public void testSerialize() throws Exception {
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

        assertThat(this.paymentJson.write(paymentInfo)).hasJsonPathStringValue("@.merchantId");
        assertThat(this.paymentJson.write(paymentInfo)).extractingJsonPathStringValue("@.merchantId")
                .isEqualTo("SADASD");
    }

    @Test
    public void testDeserialize() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        CardInfo cardInfo = new CardInfo();
        cardInfo.setBin("412323232323");
        cardInfo.setCardholderName("Mark");
        cardInfo.setCvv("123");
        cardInfo.setExpirationMonth("12");
        cardInfo.setExpirationYear("21");

        String content = objectMapper.writeValueAsString(cardInfo);

        assertThat(this.cardJson.parseObject(content).getBin()).isEqualTo("412323232323");
    }

}