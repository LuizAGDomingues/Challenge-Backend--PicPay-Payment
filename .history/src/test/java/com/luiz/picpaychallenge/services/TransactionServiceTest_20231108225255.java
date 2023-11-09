package com.luiz.picpaychallenge.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.luiz.picpaychallenge.repositories.TransactionsRepository;

public class TransactionServiceTest {

  @Autowired
  private UserService userService;

  @Autowired
  private TransactionsRepository repository;

  @Autowired
  private AuthorizationService authorizationService;

  @Autowired
  private NotificationService notificationService;

  @Test
  @DisplayName("Should create transaction successfully when everything is ok")
  void testCreateTransactionSuccess() {

  }

  @Test
  @DisplayName("Should throw Exception when transaction is not allowed")
  void testCreateTransactionFail() {

  }
}
