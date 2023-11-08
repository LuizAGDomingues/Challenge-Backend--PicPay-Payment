package com.luiz.picpaychallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiz.picpaychallenge.domain.user.User;

public interface UserRepositories extends JpaRepository<User, Long> {
  findUserByDocument()
}
