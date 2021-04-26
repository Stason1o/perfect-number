package com.perfectnumbers.perfectnumber.controller;

import com.perfectnumbers.perfectnumber.service.PerfectNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PerfectNumberController {

    private final PerfectNumberService perfectNumberService;

    @GetMapping("/is-perfect/{number}")
    public boolean isPerfectNumber(@PathVariable int number)  {
        return perfectNumberService.isPerfectNumber(number);
    }

    @GetMapping("/is-perfect/{start}/{end}") // start, end could also be passed via headers, instead of url.
    public List<Long> getListOfPerfectNumbers(@PathVariable int start, @PathVariable long end)  {
        return perfectNumberService.findPerfectNumbersInRange(start, end);
    }

}
