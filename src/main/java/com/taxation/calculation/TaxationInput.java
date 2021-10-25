package com.taxation.calculation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaxationInput {

    private long traderID;
    private BigDecimal playedAmount;
    private BigDecimal odd;


}
