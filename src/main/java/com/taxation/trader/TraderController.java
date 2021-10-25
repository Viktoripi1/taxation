package com.taxation.trader;

import com.taxation.calculation.TaxationInput;
import com.taxation.calculation.TaxationOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
                             @RequestParam(required = false) BigDecimal taxRate,
                             @RequestParam(required = false) BigDecimal taxAmount) {
        traderService.updateTrader(traderID, taxRate, taxAmount);
    }

    @PostMapping(path = "/taxation")
    public ResponseEntity<Object> calculateTaxation(@RequestBody TaxationInput taxInput) {
        return traderService.calculateTaxation(taxInput);
    }

}
