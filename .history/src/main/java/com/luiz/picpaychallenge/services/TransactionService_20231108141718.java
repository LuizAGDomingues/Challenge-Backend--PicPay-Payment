package com.luiz.picpaychallenge.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.dtos.TransactionDTO;
import com.luiz.picpaychallenge.repositories.TransactionsRepository;

@Service
public class TransactionService {
  
  @Autowired
  private UserService userService;

  @Autowired
  private TransactionsRepository repository;

  @Autowired
  private RestTemplate restTemplate;

  public void createTransaction(TransactionDTO transaction) throws Exception{
    User sender = this.userService.findUserById(transaction.senderId());
    User receiver = this.userService.findUserById(transaction.receiverId());

    userService.validateTransaction(sender, transaction.value());

    if(){}
  }

  public boolean authorizeTransactions(User sender, BigDecimal value){
    = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map);
  }
}
