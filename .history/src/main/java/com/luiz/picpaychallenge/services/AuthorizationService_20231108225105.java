package com.luiz.picpaychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {
  @Autowired
  private RestTemplate restTemplate;
}
