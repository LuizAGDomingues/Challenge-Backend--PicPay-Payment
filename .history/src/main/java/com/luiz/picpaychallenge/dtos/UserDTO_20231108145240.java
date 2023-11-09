package com.luiz.picpaychallenge.dtos;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, Strign email, String) {
  
}
