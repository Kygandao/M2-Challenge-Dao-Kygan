package com.company.M2ChallengeDaoKygan.controller;

import com.company.M2ChallengeDaoKygan.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MathSolutionController {

    //TODO: REFACTOR TO ELIMINATE REDUNDANCY - SEE LINE 107
    //ADD
        @PostMapping("/add")
        @ResponseStatus(value = HttpStatus.OK)
        public MathSolution add(@Valid @RequestBody MathSolution mathSolution) {
            try {
                Integer inputNumber1 = mathSolution.getOperand1();
                Integer inputNumber2 = mathSolution.getOperand2();

                if (inputNumber1 == null || inputNumber2 == null) {
                    throw new NumberFormatException("ENTERED VALUE MUST BE A NUMBER AND MUST NOT BE BLANK");
                }
                mathSolution.setOperand1(inputNumber1);
                mathSolution.setOperand2(inputNumber2);
                mathSolution.setOperation("add");
                mathSolution.setAnswer(mathSolution.add(inputNumber1, inputNumber2));

                return mathSolution;
            } catch (HttpMessageNotReadableException e) {
                throw e;
            }
        }

        //SUBTRACT
        @PostMapping("/subtract")
        @ResponseStatus(value = HttpStatus.OK)
        public MathSolution subtract (@Valid @RequestBody MathSolution mathSolution) {
            try {
                Integer inputNumber1 = mathSolution.getOperand1();
                Integer inputNumber2 = mathSolution.getOperand2();

                if (inputNumber1 == null || inputNumber2 == null) {
                    throw new NumberFormatException("ENTERED VALUE MUST BE A NUMBER AND MUST NOT BE BLANK");
                }

                mathSolution.setOperand1(inputNumber1);
                mathSolution.setOperand2(inputNumber2);
                mathSolution.setOperation("subtract");
                mathSolution.setAnswer(mathSolution.subtract(inputNumber1, inputNumber2));

                return mathSolution;
            } catch (HttpMessageNotReadableException e) {
                throw e;
            }
        }

        //MULTIPLY
        @PostMapping("/multiply")
        @ResponseStatus(value = HttpStatus.OK)
        public MathSolution multiply (@Valid @RequestBody MathSolution mathSolution){
            try {
                Integer inputNumber1 = mathSolution.getOperand1();
                Integer inputNumber2 = mathSolution.getOperand2();

                if (inputNumber1 == null || inputNumber2 == null) {
                    throw new NumberFormatException("ENTERED VALUE MUST BE A NUMBER AND MUST NOT BE BLANK");
                }

                mathSolution.setOperand1(inputNumber1);
                mathSolution.setOperand2(inputNumber2);
                mathSolution.setOperation("multiply");
                mathSolution.setAnswer(mathSolution.multiply(inputNumber1, inputNumber2));

                return mathSolution;
            } catch (HttpMessageNotReadableException e) {
                throw e;
            }
        }

        //DIVIDE
        @PostMapping("/divide")
        @ResponseStatus(value = HttpStatus.OK)
        public MathSolution divide (@Valid @RequestBody MathSolution mathSolution){

            Integer inputNumber1 = mathSolution.getOperand1();
            Integer inputNumber2 = mathSolution.getOperand2();
            try {
                if (inputNumber1 == null || inputNumber2 == null) {
                    throw new NumberFormatException("ENTERED VALUE MUST BE A NUMBER AND MUST NOT BE BLANK");
                } else if (inputNumber2 == 0) {
                    throw new IllegalArgumentException("CANNOT DIVIDE BY ZERO");
                }

                mathSolution.setOperand1(inputNumber1);
                mathSolution.setOperand2(inputNumber2);
                mathSolution.setOperation("divide");
                mathSolution.setAnswer(mathSolution.divide(inputNumber1, inputNumber2));

                return mathSolution;
            } catch (HttpMessageNotReadableException e) {
                throw e;
            }
        }

        //TODO: COMPLETE HELPER METHOD TO ELIMINATE REDUNDANCIES
        //HELPER METHOD TO REPLACE TRY CATCH BLOCKS FROM EACH MATH OPERATOR METHOD - VERIFY VALID INPUT
            //OPERATION AND ANSWER TO BE SET IN EACH CORRESPONDING METHOD

//        MathSolution validInput = new MathSolution();
//        Integer number1 = validInput.getOperand1();
//        Integer number2 = validInput.getOperand2();
//        private MathSolution setIfValidInput(MathSolution validInput) {
//           try {
//               if(number1 == null || number2 == null) {
//                   throw new IllegalArgumentException("ENTERED VALUE MUST BE A NUMBER AND MUST NOT BE BLANK");
//               }
//               validInput.setOperand1(number1);
//               validInput.setOperand2(number2);
//               return validInput;
//           } catch (HttpMessageNotReadableException e) {
//               throw e;
//           }
//        }



    }


