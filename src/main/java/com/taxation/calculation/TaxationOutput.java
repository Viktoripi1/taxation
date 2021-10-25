package com.taxation.calculation;

import com.taxation.trader.Trader;

public class TaxationOutput {

    private float possibleReturnAmount;
    private float possibleReturnAmountBefTax;
    private float possibleReturnAmountAfterTax;
    private float taxRate;
    private float taxAmount;

    public TaxationOutput() {
    }

    public TaxationOutput(float possibleReturnAmount, float possibleReturnAmountBefTax, float possibleReturnAmountAfterTax, float taxRate, float taxAmount) {
        this.possibleReturnAmount = possibleReturnAmount;
        this.possibleReturnAmountBefTax = possibleReturnAmountBefTax;
        this.possibleReturnAmountAfterTax = possibleReturnAmountAfterTax;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
    }

    public float getPossibleReturnAmount() {
        return possibleReturnAmount;
    }

    public void setPossibleReturnAmount(float possibleReturnAmount) {
        this.possibleReturnAmount = possibleReturnAmount;
    }

    public float getPossibleReturnAmountBefTax() {
        return possibleReturnAmountBefTax;
    }

    public void setPossibleReturnAmountBefTax(float possibleReturnAmountBefTax) {
        this.possibleReturnAmountBefTax = possibleReturnAmountBefTax;
    }

    public float getPossibleReturnAmountAfterTax() {
        return possibleReturnAmountAfterTax;
    }

    public void setPossibleReturnAmountAfterTax(float possibleReturnAmountAfterTax) {
        this.possibleReturnAmountAfterTax = possibleReturnAmountAfterTax;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Override
    public String toString() {
        return "outgoing{" +
                "possibleReturnAmount:" + possibleReturnAmount +
                ", possibleReturnAmountBefTax:" + possibleReturnAmountBefTax +
                ", possibleReturnAmountAfterTax:" + possibleReturnAmountAfterTax +
                ", taxRate:" + taxRate +
                ", taxAmount:" + taxAmount +
                '}';
    }

    public TaxationOutput calculate(TaxationInput input, Trader trader) {
        TaxationOutput output = new TaxationOutput();
        output.possibleReturnAmount = input.getPlayedAmount() * input.getOdd();
        output.possibleReturnAmountBefTax = output.possibleReturnAmount * trader.getTaxRate();
        output.possibleReturnAmountAfterTax = output.possibleReturnAmount - output.possibleReturnAmountBefTax;
        output.taxRate = trader.getTaxRate();
        output.taxAmount = trader.getTaxAmount();
        return output;
    }
}
