package com.luiz.picpaychallenge.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.domain.user.UserType;
import com.luiz.picpaychallenge.dtos.TransactionDTO;
import com.luiz.picpaychallenge.repositories.TransactionsRepository;

public class TransactionServiceTest {

  @Mock
  private UserService userService;

  @Mock
  private TransactionsRepository repository;

  @Mock
  private AuthorizationService authorizationService;

  @Mock
  private NotificationService notificationService;

  @Autowired
  @InjectMocks
  private TransactionService transactionService;

  @BeforeEach
  void setup(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should create transaction successfully when everything is ok")
  void testCreateTransactionSuccess() throws Exception {
    User sender = new User(1L, "Luiz", "Souza", "123456789", "luiz@teste.com", "111", new BigDecimal(10), UserType.COMMON);
    User receiver = new User(2L, "Joao", "Souza", "123456798", "joao@teste.com", "111", new BigDecimal(10), UserType.COMMON);
  
    when(userService.findUserById(1L)).thenReturn(sender);
    when(userService.findUserById(2L)).thenReturn(receiver);

    when(authorizationService.authorizeTransactions(any(), any())).thenReturn(true);

    TransactionDTO request = new TransactionDTO(new BigDecimal(10), 1L, 2L);
    transactionService.createTransaction(request);
  
    verify(repository, times(1)).save(any());

    sender.setBalance(new BigDecimal(0));
    verify(userService, times(1)).saveUser(sender);

    receiver.setBalance(new BigDecimal(20));
    verify(userService, times(1)).saveUser(receiver);

    verify(notificationService, times(1)).sendNotification(sender, "Transação realizada com sucesso");
    verify(notificationService, times(1)).sendNotification(receiver, "Transação recebida com sucesso");
  }

  @Test
  @DisplayName("Should throw Exception when transaction is not allowed")
  void testCreateTransactionFail() throws Exception {
    User sender = new User(1L, "Luiz", "Souza", "123456789", "luiz@teste.com", "111", new BigDecimal(10), UserType.COMMON);
    User receiver = new User(2L, "Joao", "Souza", "123456798", "joao@teste.com", "111", new BigDecimal(10), UserType.COMMON);
  
    when(userService.findUserById(1L)).thenReturn(sender);
    when(userService.findUserById(2L)).thenReturn(receiver);

    when(authorizationService.authorizeTransactions(any(), any())).thenReturn(false);

    Exception thrown = Asser;
  }
}
