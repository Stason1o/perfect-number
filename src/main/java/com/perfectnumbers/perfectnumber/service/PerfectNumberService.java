package com.perfectnumbers.perfectnumber.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class PerfectNumberService {

    //validation if number is positive or negative could be done by swagger validation, instead of validating here.
    public boolean isPerfectNumber(long number) {
        long sum = LongStream.rangeClosed(1, number / 2)
                .filter(elem -> number % elem == 0)
                .sum();

        return sum == number;
    }

    public List<Long> findPerfectNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .filter(this::isPerfectNumber)
                .boxed()
                .collect(Collectors.toList());
    }
}
