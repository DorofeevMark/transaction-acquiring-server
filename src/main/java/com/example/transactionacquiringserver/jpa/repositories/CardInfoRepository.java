package com.example.transactionacquiringserver.jpa.repositories;

import com.example.transactionacquiringserver.jpa.models.CardInfo;
import org.springframework.data.repository.CrudRepository;

public interface CardInfoRepository extends CrudRepository<CardInfo, Integer> {
}
