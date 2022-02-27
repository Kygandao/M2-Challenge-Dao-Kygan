package com.company.M2ChallengeDaoKygan.controller;

import com.company.M2ChallengeDaoKygan.model.MathSolution;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MathSolutionController {

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution add(@RequestBody @Valid MathSolution mathSolution) {
        MathSolution additionSolution = new MathSolution();
        additionSolution.setOperand1(mathSolution.getOperand1());
        additionSolution.setOperand2(mathSolution.getOperand2());
        additionSolution.setOperation("add");
        //TODO: ADD EXCEPTION/ERROR HANDLING FOR MISSING OR INVALID TYPE

        System.out.println("PERFORMING ADDITION");

        additionSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());
        return additionSolution;

    }

    @PostMapping("/subtract")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution subtract(@RequestBody @Valid MathSolution mathSolution) {
        MathSolution subtractionSolution = new MathSolution();
        subtractionSolution.setOperand1(mathSolution.getOperand1());
        subtractionSolution.setOperand2(mathSolution.getOperand2());
        subtractionSolution.setOperation("subtract");
        //TODO: ADD EXCEPTION/ERROR HANDLING FOR MISSING OR INVALID TYPE

        System.out.println("PERFORMING SUBTRACTION");


        subtractionSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        return subtractionSolution;

    }

    @PostMapping("/multiply")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution multiply(@RequestBody @Valid MathSolution mathSolution) {
        MathSolution multiplicationSolution = new MathSolution();
        multiplicationSolution.setOperand1(mathSolution.getOperand1());
        multiplicationSolution.setOperand2(mathSolution.getOperand2());
        multiplicationSolution.setOperation("multiply");
        //TODO: ADD EXCEPTION/ERROR HANDLING FOR MISSING OR INVALID TYPE

        System.out.println("PERFORMING MULTIPLICATION");

        multiplicationSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());
        return multiplicationSolution;

    }

    @PostMapping("/divide")
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(InvalidFormatException.class)
    public MathSolution divide(@RequestBody @Valid MathSolution mathSolution) {

        MathSolution divisionSolution = new MathSolution();
        divisionSolution.setOperand1(mathSolution.getOperand1());
        divisionSolution.setOperand2(mathSolution.getOperand2());
        divisionSolution.setOperation("divide");

        //TODO: CHECK IF NUMERATOR/DENOMINATOR IS WRONG DATA TYPE, OR MISSING

        if(divisionSolution.getOperand2().equals(0)) {
            System.out.println("CANNOT DIVIDE BY ZERO");
            throw new IllegalArgumentException("CANNOT DIVIDE BY ZERO");
        }

        System.out.println("PERFORMING DIVISION");
        divisionSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());

        return divisionSolution;

    }

}
