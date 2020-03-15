package com.example.transactionacquiringserver.jpa.repositories;

import com.example.transactionacquiringserver.jpa.models.TransactionLog;
import org.springframework.data.repository.CrudRepository;

public interface TransactionLogRepository extends CrudRepository<TransactionLog, Integer> {
}
