package com.perfectnumbers.perfectnumber.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PerfectNumberServiceTest {

    private final PerfectNumberService service = new PerfectNumberService();

    @ParameterizedTest
    @MethodSource("perfectNumbersArgument")
    void testValidPerfectNumber(long number, boolean expectedResponse) {
        assertThat(service.isPerfectNumber(number)).isEqualTo(expectedResponse);
    }

    @Test
    void findPerfectNumbersInRange() {
        assertThat(service.findPerfectNumbersInRange(1, 1000)).contains(6L, 28L, 496L);
    }

    private static Stream<Arguments> perfectNumbersArgument() {
        return Stream.of(
                Arguments.arguments(28, true),
                Arguments.arguments(50, false),
                Arguments.arguments(496, true),
                Arguments.arguments(500, false)
        );
    }
}