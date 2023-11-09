package com.luiz.picpaychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.dtos.TransactionDTO;
import com.luiz.picpaychallenge.repositories.TransactionsRepository;

@Service
public class TransactionService {
  
  @Autowired
  private UserService userService;

  @Autowired
  private TransactionsRepository repository;

  public void createTransaction(TransactionDTO transaction) throws Exception{
    User sender = this.userService.findUserById(transaction.senderId());
    User receiver = this.userService.findUserById(transaction.receiverId());

    userService.validateTransaction(sender, transaction.value());

    if(){}
  }

  public boolean authorizeTransactions()
}
