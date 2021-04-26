package com.perfectnumbers.perfectnumber.controller;

import com.perfectnumbers.perfectnumber.service.PerfectNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PerfectNumberController.class)
@AutoConfigureWebClient
class PerfectNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PerfectNumberService service;

    @Test
    void shouldValidatePerfectNumber() throws Exception {
        when(service.isPerfectNumber(20)).thenReturn(false);

        this.mockMvc.perform(get("/is-perfect/20"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));
    }

    @Test
    void shouldGetPerfectNumbersList() throws Exception {
        when(service.findPerfectNumbersInRange(1, 1000)).thenReturn(asList(6L, 28L, 496L));

        this.mockMvc.perform(get("/is-perfect/1/1000"))
                .andExpect(status().isOk())
                .andExpect(content().json("[6, 28, 496]"));
    }
}