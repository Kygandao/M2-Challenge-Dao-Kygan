package com.company.M2ChallengeDaoKygan.controller;

import com.company.M2ChallengeDaoKygan.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
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

    //I'M SURE THERE'S A MORE ELEGANT SOLUTION USING THE JAVA.TIME ENUM BUT I'M NOT SURE HOW TO SET IT UP.
    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByMonthNumber(@PathVariable int monthNumber) {

        if(monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Month number does not exist");
        }

        //TODO: CREATE CHECK FOR PROPER INPUT TYPE. MUST BE INT BETWEEN 1-12, NOT A STRING

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
