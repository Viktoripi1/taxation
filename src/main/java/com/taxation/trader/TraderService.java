package com.taxation.trader;

import com.taxation.calculation.CalculationService;
import com.taxation.calculation.TaxationInput;
import com.taxation.calculation.TaxationOutput;
import com.taxation.exception.DataNotFoundException;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@ToString
public class TraderService {

    private final TraderRepository traderRepository;
    private final CalculationService calculationService;

    @Autowired
    public TraderService(TraderRepository traderRepository, CalculationService calculationSevice) {
        this.traderRepository = traderRepository;
        this.calculationService = calculationSevice;
    }

    public List<Trader> getTraders() {
        return traderRepository.findAll();
    }

    public Trader getTraderByID(Long traderId) {
        return traderRepository.findById(traderId).orElseThrow(() ->
                new DataNotFoundException("Trader with id "+ traderId +" doesn't exist!"));
    }


    public void addNewTrader(Trader trader) {
        traderRepository.save(trader);
    }

    public void deleteTrader(Long traderId) {
        if (!traderRepository.existsById(traderId)) {
            throw new DataNotFoundException("Trader doesn't exist!");
        }
        traderRepository.deleteById(traderId);
    }

    @Transactional
    public void updateTrader(Long traderID, BigDecimal taxRate, BigDecimal taxAmount) {
        Trader trader = getTraderByID(traderID);

        if (taxRate != null && taxRate.compareTo(BigDecimal.valueOf(0)) < 0) {
            trader.setTaxRate(taxRate);
        }
        if (taxAmount != null && taxAmount.compareTo(BigDecimal.valueOf(0)) < 0) {
            trader.setTaxAmount(taxAmount);
        }
    }

    public ResponseEntity<TaxationOutput> calculateTaxation(TaxationInput taxationInput){
        Trader trader = traderRepository.getById(taxationInput.getTraderID());
        return ResponseEntity.ok(calculationService.calculate(taxationInput,trader));
    }
}
