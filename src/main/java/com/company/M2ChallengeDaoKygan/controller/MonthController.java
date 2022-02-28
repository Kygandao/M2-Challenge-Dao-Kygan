package com.company.M2ChallengeDaoKygan.controller;

import com.company.M2ChallengeDaoKygan.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class MonthController {

    //CREATE LIST OF MONTHS
    private final static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
    ));


    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByMonthNumber(@Valid @PathVariable int monthNumber) {

        if(monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("NUMBER ENTERED SHOULD BE 1 THROUGH 12 ");
        }

        System.out.println("CONVERTING MONTH NUMBER TO MONTH NAME");
        return monthList.get(monthNumber - 1);

    }

    @GetMapping("/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        Random random = new Random();
        System.out.println("GETTING RANDOM MONTH");
        return monthList.get(random.nextInt(monthList.size()));
    }


}
