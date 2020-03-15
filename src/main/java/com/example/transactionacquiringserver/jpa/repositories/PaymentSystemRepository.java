package com.example.transactionacquiringserver.jpa.repositories;

import com.example.transactionacquiringserver.jpa.models.PaymentSystem;
import org.springframework.data.repository.CrudRepository;

public interface PaymentSystemRepository extends CrudRepository<PaymentSystem, Integer> {
}
