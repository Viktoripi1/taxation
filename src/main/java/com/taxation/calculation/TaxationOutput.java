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

}
