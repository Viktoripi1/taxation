package com.taxation.calculation;

import com.taxation.trader.Trader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CalculationService {

    public ResponseEntity<Object> calculate(TaxationInput taxationInput, Trader trader) {
        try {
            if (trader != null) {
                TaxationOutput output = new TaxationOutput();
                output = output.calculate(taxationInput, trader);
                return new ResponseEntity<>(output, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("TraderID not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
