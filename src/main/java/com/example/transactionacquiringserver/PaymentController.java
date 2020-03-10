package com.example.transactionacquiringserver;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaymentController {
    @GetMapping("/proceed")
    public Map<String, String> payment() {
        return Collections.singletonMap("response", "Hello World");
    }
}
