package com.taxation.calculation;

import com.taxation.trader.Trader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CalculationService {

    public TaxationOutput calculate(TaxationInput input, Trader trader) {
        TaxationOutput output = new TaxationOutput();

        output.setPossibleReturnAmount(input.getPlayedAmount().multiply(input.getOdd()));
        output.setPossibleReturnAmountBefTax(output.getPossibleReturnAmount().multiply(trader.getTaxRate()));
        output.setPossibleReturnAmountAfterTax(output.getPossibleReturnAmount()
                .subtract(output.getPossibleReturnAmountBefTax()));
        output.setTaxRate(trader.getTaxRate());
        output.setTaxAmount(trader.getTaxAmount());

        return output;
    }

}
