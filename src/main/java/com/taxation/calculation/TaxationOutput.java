package com.taxation.calculation;

import com.taxation.trader.Trader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaxationOutput {

    private BigDecimal possibleReturnAmount;
    private BigDecimal possibleReturnAmountBefTax;
    private BigDecimal possibleReturnAmountAfterTax;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;

    public TaxationOutput calculate(TaxationInput input, Trader trader) {
        TaxationOutput output = new TaxationOutput();
        output.setPossibleReturnAmount(input.getPlayedAmount().multiply(input.getOdd()));
        output.setPossibleReturnAmountBefTax(output.possibleReturnAmount.multiply(trader.getTaxRate()));
        output.setPossibleReturnAmountAfterTax(output.possibleReturnAmount.subtract(output.possibleReturnAmountBefTax));
        output.taxRate = trader.getTaxRate();
        output.taxAmount = trader.getTaxAmount();
        return output;
    }
}
