package com.luiz.picpaychallenge.repositories;

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
  void testFindUserByDocument() {
    
  }

  private User createUser(UserDTO data){}
}
