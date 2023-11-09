package com.luiz.picpaychallenge.dtos;

import java.math.BigDecimal;

import com.luiz.picpaychallenge.domain.user.UserType;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType) {
  
}
