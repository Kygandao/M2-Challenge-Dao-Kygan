package com.company.M2ChallengeDaoKygan.model;

import javax.validation.constraints.NotNull;

public class MathSolution {

    @NotNull(message = "YOU MUST SUPPLY A NUMBER")
    private Integer operand1;

    @NotNull(message = "YOU MUST SUPPLY A NUMBER THAT IS NOT ZERO")
    private Integer operand2;

    private String operation;
    private Integer answer;

    public MathSolution() {
    }

    public MathSolution(Integer operand1, Integer operand2, String operation, Integer answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    //Calculator Methods
    public Integer add(Integer operand1out, Integer operand2out) {
        return operand1out + operand2out;
    }

    public Integer subtract(Integer operand1out, Integer operand2out) {
        return operand1out - operand2out;
    }

    public Integer multiply(Integer operand1out, Integer operand2out) {
        return operand1out * operand2out;
    }

    public Integer divide(Integer operand1out, Integer operand2out) {
        return operand1out / operand2out;
    }
}
