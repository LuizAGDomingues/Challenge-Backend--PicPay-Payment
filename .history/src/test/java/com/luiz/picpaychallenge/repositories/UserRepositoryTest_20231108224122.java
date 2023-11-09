package com.luiz.picpaychallenge.repositories;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.domain.user.UserType;
import com.luiz.picpaychallenge.dtos.UserDTO;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
  @Autowired
  UserRepository userRepository;

  @Autowired
  EntityManager entityManager;

  @Test
  @DisplayName("Should get user successfully from db")
  void testFindUserByDocumentSuccess() {
    String document = "123456789";
    UserDTO data = new UserDTO("Luiz", "Teste", document, new BigDecimal(10), "test@gmail.com", "111", UserType.COMMON);
    this.createUser(data);

    Optional<User> result = this.userRepository.findUserByDocument(document);

    assertThat(result.isPresent()).isTrue();
  }

  @Test
  @DisplayName("Should not get user from db")
  void testFindUserByDocumentSuccess() {
    String document = "123456789";
    UserDTO data = new UserDTO("Luiz", "Teste", document, new BigDecimal(10), "test@gmail.com", "111", UserType.COMMON);
    this.createUser(data);

    Optional<User> result = this.userRepository.findUserByDocument(document);

    assertThat(result.isPresent()).isTrue();
  }

  private User createUser(UserDTO data){
    User newUser = new User(data);
    this.entityManager.persist(newUser);
    return newUser;
  }
}
