package com.luiz.picpaychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.picpaychallenge.repositories.TransactionsRepository;

@Service
public class TransactionService {
  
  @Autowired
  private UserService userService;

  @Autowired
  private TransactionsRepository repository;

  public void createTransaction(TransactionDTO){}
}
