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

import java.util.HashMap;
import java.util.Map;

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


    //ADDITION CASE TESTS LINE 37 - 130
    //SUCCESSFUL CASE
    @Test
    public void shouldReturnSumOfTwoInts() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(10);
        inputValues.setOperand2(5);

        String inputJson = mapper.writeValueAsString(inputValues);

        MathSolution outputValues = new MathSolution(10, 5, "add", 15);

        String outputJson = mapper.writeValueAsString(outputValues);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1IsMissingDuringAddition() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand2(5);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand2IsMissingDuringAddition() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(10);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1AndOperand2AreMissingDuringAddition() throws Exception {

        MathSolution inputValues = new MathSolution();

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - INVALID INPUT TYPE
    @Test
    public void shouldReturnErrorCode422IfInputIsNotAnIntegerDuringAddition() throws Exception {

        Map<String, String> inputValues = new HashMap<>();
        inputValues.put("operand1", "number");
        inputValues.put("operand2", "second number");

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //SUBTRACTION CASE TESTS LINES 134 - 227
    //SUCCESSFUL CASE
    @Test
    public void shouldReturnDifferenceOfTwoInts() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(6);
        inputValues.setOperand2(2);

        String inputJson = mapper.writeValueAsString(inputValues);

        MathSolution outputValues = new MathSolution(6, 2, "subtract", 4);

        String outputJson = mapper.writeValueAsString(outputValues);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1IsMissingDuringSubtraction() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand2(2);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand2IsMissingDuringSubtraction() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(6);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1AndOperand2AreMissingDuringSubtraction() throws Exception {

        MathSolution inputValues = new MathSolution();

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - INVALID INPUT TYPE
    @Test
    public void shouldReturnErrorCode422IfInputIsNotAnIntegerDuringSubtraction() throws Exception {

        Map<String, String> inputValues = new HashMap<>();
        inputValues.put("operand1", "number");
        inputValues.put("operand2", "second number");

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //MULTIPLICATION CASE TESTS LINES 231 - 324
    //SUCCESSFUL CASE
    @Test
    public void shouldReturnProductOfTwoInts() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(5);
        inputValues.setOperand2(3);

        String inputJson = mapper.writeValueAsString(inputValues);

        MathSolution outputValues = new MathSolution(5, 3, "multiply", 15);

        String outputJson = mapper.writeValueAsString(outputValues);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1IsMissingDuringMultiplication() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand2(2);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand2IsMissingDuringMultiplication() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(6);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1AndOperand2AreMissingDuringMultiplication() throws Exception {

        MathSolution inputValues = new MathSolution();

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - INVALID INPUT TYPE
    @Test
    public void shouldReturnErrorCode422IfInputIsNotAnIntegerDuringMultiplication() throws Exception {

        Map<String, String> inputValues = new HashMap<>();
        inputValues.put("operand1", "number");
        inputValues.put("operand2", "second number");

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //DIVISION CASE TESTS LINES 328 - 464
    //SUCCESSFUL CASE
    @Test
    public void shouldReturnQuotientOfTwoInts() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(10);
        inputValues.setOperand2(2);

        String inputJson = mapper.writeValueAsString(inputValues);

        MathSolution outputValues = new MathSolution(10, 2, "divide", 5);

        String outputJson = mapper.writeValueAsString(outputValues);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    //SUCCESSFUL CASE - ZERO NUMERATOR
    @Test
    public void shouldReturnZeroWhenOperand1IsZero() throws Exception {
        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(0);
        inputValues.setOperand2(10);

        String inputJson = mapper.writeValueAsString(inputValues);

        MathSolution outputValues = new MathSolution(0, 10, "divide", 0);

        String outputJson = mapper.writeValueAsString(outputValues);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    //EXPECTED FAILURE - DIVIDE BY ZERO
    @Test
    public void shouldReturnErrorCode422IfOperand2IsZero() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(10);
        inputValues.setOperand2(0);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1IsMissingDuringDivision() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand2(2);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand2IsMissingDuringDivision() throws Exception {

        MathSolution inputValues = new MathSolution();
        inputValues.setOperand1(6);

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - MISSING INPUT
    @Test
    public void shouldReturnErrorCode422IfOperand1AndOperand2AreMissingDuringDivision() throws Exception {

        MathSolution inputValues = new MathSolution();

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //EXPECTED FAILURE - INVALID INPUT TYPE
    @Test
    public void shouldReturnErrorCode422IfInputIsNotAnIntegerDuringDivision() throws Exception {

        Map<String, String> inputValues = new HashMap<>();
        inputValues.put("operand1", "number");
        inputValues.put("operand2", "second number");

        String inputJson = mapper.writeValueAsString(inputValues);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //END OF TESTS

}