package com.taxation.trader;

import com.taxation.calculation.TaxationInput;
import com.taxation.calculation.TaxationOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraderController {

    private final TraderService traderService;

    public TraderController(TraderService traderService) {
        this.traderService = traderService;
    }

    @GetMapping("/trader")
    public List<Trader> getTraders() {
        return traderService.getTraders();
    }

    @PostMapping("/trader")
    public void registerTrader(@RequestBody Trader trader) {
        traderService.addNewTrader(trader);
    }

    @DeleteMapping(path = "/trader/{traderID}")
    public void deleteTrader(@PathVariable("traderID") Long traderID) {
        traderService.deleteTrader(traderID);
    }

    @PutMapping(path = "/trader/{traderID}")
    public void updateTrader(@PathVariable Long traderID,
                             @RequestParam(required = false) Float taxRate,
                             @RequestParam(required = false) Float taxAmount) {
        traderService.updateTrader(traderID, taxRate, taxAmount);
    }

    @PostMapping(path = "/taxation")
    public ResponseEntity<Object> calculateTaxation(@RequestBody TaxationInput taxInput) {
        try {
            Trader trader = traderService.getTraderByID(taxInput.getTraderID());
            if (trader != null) {
                TaxationOutput output = new TaxationOutput();
                output = output.calculate(taxInput, trader);
                return new ResponseEntity<>(output, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("TraderID not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


    }

}
