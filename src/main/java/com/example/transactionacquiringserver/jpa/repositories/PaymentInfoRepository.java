package com.example.transactionacquiringserver.jpa.repositories;

import com.example.transactionacquiringserver.jpa.models.PaymentInfo;
import org.springframework.data.repository.CrudRepository;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Integer> {
}
