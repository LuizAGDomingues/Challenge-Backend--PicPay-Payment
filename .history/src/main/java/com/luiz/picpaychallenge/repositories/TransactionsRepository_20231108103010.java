package com.luiz.picpaychallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiz.picpaychallenge.domain.transaction.Transaction;

public interface TransactionsRepository extends JpaRepository<Transaction> {
  
}
