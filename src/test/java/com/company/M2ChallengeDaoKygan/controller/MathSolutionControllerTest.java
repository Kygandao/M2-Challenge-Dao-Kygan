package com.company.M2ChallengeDaoKygan.controller;

import com.company.M2ChallengeDaoKygan.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    //TODO: ADD TEST FOR INVALID ADDITION REQUEST
    //TEST SUCCESSFUL ADDITION REQUEST
    @Test
    public void shouldReturnSumOfTwoInts() throws Exception {

        MathSolution inputAddition = new MathSolution();
        inputAddition.setOperand1(10);
        inputAddition.setOperand2(10);

        String inputJson = mapper.writeValueAsString(inputAddition);

        MathSolution outputAddition = new MathSolution();
        outputAddition.setOperand1(10);
        outputAddition.setOperand2(10);
        outputAddition.setOperation("add");
        outputAddition.setAnswer(20);

        String outputJson = mapper.writeValueAsString(outputAddition);

        mockMvc.perform(post("/add")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }


    //TEST INVALID ADDITION REQUEST
    @Test
    public void shouldReturn422StatusIfAdditionIsMissingOrNotNumbers() throws Exception {

        MathSolution inputAddition = new MathSolution();
        inputAddition.setOperand1(10);
        //MISSING OPERAND 2
        String inputJson = mapper.writeValueAsString(inputAddition);

        MathSolution outputAddition = new MathSolution();
        outputAddition.setOperand1(10);
        outputAddition.setOperand2(10);
        outputAddition.setOperation("add");
        outputAddition.setAnswer(20);

        String outputJson = mapper.writeValueAsString(outputAddition);

        //TODO: GETTING 400 ERROR INSTEAD OF 422
        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().json(outputJson));

    }


    //TEST SUCCESSFUL SUBTRACTION REQUEST
    @Test
    public void shouldReturnDifferenceOfTwoInts() throws Exception{
        MathSolution inputSubtraction = new MathSolution();
        inputSubtraction.setOperand1(50);
        inputSubtraction.setOperand2(30);

        String inputJson = mapper.writeValueAsString(inputSubtraction);

        MathSolution outputSubtraction = new MathSolution();
        outputSubtraction.setOperand1(50);
        outputSubtraction.setOperand2(30);
        outputSubtraction.setOperation("subtract");
        outputSubtraction.setAnswer(20);

        String outputJson = mapper.writeValueAsString(outputSubtraction);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    //TEST INVALID SUBTRACTION REQUEST
    @Test
    public void shouldReturn422StatusIfSubtractionIsMissingOrNotNumbers() throws Exception {

        MathSolution inputSubtraction = new MathSolution();
        inputSubtraction.setOperand1(50);
        //MISSING OPERAND2
        String inputJson = mapper.writeValueAsString(inputSubtraction);

        MathSolution outputSubtraction = new MathSolution();
        outputSubtraction.setOperand1(50);
        outputSubtraction.setOperand2(30);
        outputSubtraction.setOperation("subtract");
        outputSubtraction.setAnswer(20);

        String outputJson = mapper.writeValueAsString(outputSubtraction);

        //TODO: GETTING 400 ERROR INSTEAD OF 422
        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().json(outputJson));

    }


    //TEST SUCCESSFUL MULTIPLICATION REQUEST
    @Test
    public void shouldReturnProductOfTwoInts() throws Exception{
        MathSolution inputMultiplication = new MathSolution();
        inputMultiplication.setOperand1(10);
        inputMultiplication.setOperand2(10);

        String inputJson = mapper.writeValueAsString(inputMultiplication);

        MathSolution outputMultiplication = new MathSolution();
        outputMultiplication.setOperand1(10);
        outputMultiplication.setOperand2(10);
        outputMultiplication.setOperation("multiply");
        outputMultiplication.setAnswer(100);

        String outputJson = mapper.writeValueAsString(outputMultiplication);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    //TEST INVALID MULTIPLICATION REQUEST
    @Test
    public void shouldReturn422StatusIfMultiplicationIsMissingOrNotNumbers() throws Exception {

        MathSolution inputAddition = new MathSolution();
        inputAddition.setOperand1(10);
        //MISSING OPERAND2

        String inputJson = mapper.writeValueAsString(inputAddition);

        MathSolution outputAddition = new MathSolution();
        outputAddition.setOperand1(10);
        outputAddition.setOperand2(10);
        outputAddition.setOperation("multiply");
        outputAddition.setAnswer(100);

        String outputJson = mapper.writeValueAsString(outputAddition);

        //TODO: GETTING 400 ERROR INSTEAD OF 422
        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().json(outputJson));

    }

    //TEST SUCCESSFUL DIVISION REQUEST
    @Test
    public void shouldReturnQuotientOfTwoInts() throws Exception{
        MathSolution inputDivision = new MathSolution();
        inputDivision.setOperand1(10);
        inputDivision.setOperand2(2);

        String inputJson = mapper.writeValueAsString(inputDivision);

        MathSolution outputDivision = new MathSolution();
        outputDivision.setOperand1(10);
        outputDivision.setOperand2(2);
        outputDivision.setOperation("divide");
        outputDivision.setAnswer(5);

        String outputJson = mapper.writeValueAsString(outputDivision);

        mockMvc.perform(post("/divide")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    //TEST INVALID DIVISION REQUEST
    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {

        //TEST MISSING OR NOT NUMBER
        MathSolution divisionSolution = new MathSolution();
        divisionSolution.setOperand1(10);
        //MISSING OPERAND2

        String inputJson = mapper.writeValueAsString(divisionSolution);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        //TEST DIVIDE BY ZERO
        MathSolution divideByZero = new MathSolution();
        divideByZero.setOperand1(10);
        divideByZero.setOperand2(0);

        String inputJsonDivideByZero = mapper.writeValueAsString(divideByZero);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJsonDivideByZero)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


}