package com.luiz.picpaychallenge.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.domain.user.UserType;
import com.luiz.picpaychallenge.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public void validateTransaction(User sender, BigDecimal amount) throws Exception{
    if(sender.getUserType() == UserType.MERCHANT){
      throw new Exception("Usuário do tipo lojista não esta autorizado a realizar transação");
    }
    if(sender.getBalance().compareTo(amount) < 0){
      throw new Exception("Saldo insuficiente");
    }
  }

  public User findUserById(Long id){
    return this.repository.findUserById(id).orElseThrow()
  }
}
