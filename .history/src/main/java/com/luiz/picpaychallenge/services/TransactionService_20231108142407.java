package com.luiz.picpaychallenge.services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luiz.picpaychallenge.domain.transaction.Transaction;
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

    boolean isAuthorized = this.authorizeTransactions(sender, transaction.value());
    if(!isAuthorized){
      throw new Exception("Transação não autorizada");
    }

    Transaction transaction = new Transaction();
    transaction.setAmount(transaction.getAmount());
    
  }

  public boolean authorizeTransactions(User sender, BigDecimal value){
    ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);
  
    if(authorizationResponse.getStatusCode() == HttpStatus.OK){
      String message = (String) authorizationResponse.getBody().get("message");
      return "Autorizado".equalsIgnoreCase(message);
    } else return false;
  }
}
