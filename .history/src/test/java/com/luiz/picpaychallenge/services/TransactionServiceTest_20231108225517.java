package com.luiz.picpaychallenge.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

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
  @Injec
  private TransactionService transactionService;

  @Test
  @DisplayName("Should create transaction successfully when everything is ok")
  void testCreateTransactionSuccess() {

  }

  @Test
  @DisplayName("Should throw Exception when transaction is not allowed")
  void testCreateTransactionFail() {

  }
}
