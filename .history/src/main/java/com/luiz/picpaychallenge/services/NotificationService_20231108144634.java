package com.luiz.picpaychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luiz.picpaychallenge.domain.user.User;

@Service
public class NotificationService {
  @Autowired
  private RestTemplate restTemplate;

  public void sendNotification(User user, String message){
    String email = user.getEmail();
    restTemplate.postForEntity(http://o4d9z.mocklab.io/notify, email, null)
  }
}
