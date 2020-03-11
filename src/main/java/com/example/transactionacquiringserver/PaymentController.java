package com.example.transactionacquiringserver;

import com.example.transactionacquiringserver.models.CardInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaymentController {
    @PostMapping(path = "/proceed", consumes = "application/json", produces = "application/json")
    public Map<String, CardInfo> payment(@RequestBody CardInfo cardInfo) {
        return Collections.singletonMap("response", cardInfo);
    }
}

