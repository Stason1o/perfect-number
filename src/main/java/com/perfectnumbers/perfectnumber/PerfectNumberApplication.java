package com.perfectnumbers.perfectnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PerfectNumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfectNumberApplication.class, args);
    }

    @Configuration
    class RestTemplateConfig {
        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }
    }
}
