package com.puck.h2demo.restclient;

import com.puck.h2demo.model.User;
import com.puck.h2demo.util.Constants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/** Created by burak on 2019-05-19 */
@Service
public class JsonServerUserClient {
  private RestTemplate restTemplate;

  public JsonServerUserClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public List<User> getUsers() {
    ResponseEntity<List<User>> responseEntity =
        restTemplate.exchange(
            Constants.JSON_SERVER_USERS,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<User>>() {});
    return responseEntity.getBody();
  }
}
