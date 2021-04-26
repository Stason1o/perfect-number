package com.perfectnumbers.perfectnumber.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * (Fire the jetty container and publish the rest APIs    on your
 * test and use a client to send requests to the APIs).
 *
 * I am not sure if i understood correctly, but in real project, E2E tests are performed by calling the endpoint and
 * request goes through all applications in the system, if considering microservice architecture
 *
 *
 * This tests will fail if application is not up and running
 */
@SpringBootTest
class ClientTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void shouldCallAndGetResult() {

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/is-perfect/28", HttpMethod.GET, null, String.class);

        assertThat(exchange.getBody()).isEqualTo("true");
    }

    @Test
    void shouldCallAndGetListOfResults() { // in real world project, instead of String.class, should be used response entity, so we can properly work with types.
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/is-perfect/1/1000", HttpMethod.GET, null, String.class);

        assertThat(exchange.getBody()).isEqualTo("[6,28,496]");
    }

}
