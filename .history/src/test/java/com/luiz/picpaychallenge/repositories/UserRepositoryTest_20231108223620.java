package com.luiz.picpaychallenge.repositories;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.dtos.UserDTO;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
  @Autowired
  EntityManager entityManager;

  @Test
  @DisplayName("Should get user successfully from db")
  void testFindUserByDocumentSuccess() {
    String document = "123456789";
    UserDTO data = new UserDTO("Luiz", "Teste", document, new BigDecimal(10), "test@gmail.com", "111", userTyCOMMON);
  }

  private User createUser(UserDTO data){
    User newUser = new User(data);
    this.entityManager.persist(newUser);
    return newUser;
  }
}
