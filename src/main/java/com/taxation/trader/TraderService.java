package com.taxation.trader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TraderService {

    private final TraderRepository traderRepository;

    @Autowired
    public TraderService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public List<Trader> getTraders() {
        return traderRepository.findAll();
    }

    public Trader getTraderByID(Long traderId) {

        if(traderRepository.findById(traderId).isEmpty()){
            throw new IllegalStateException("Trader with id "+traderId+" doesn't exist!");
        }
        return traderRepository.getById(traderId);
    }


    public void addNewTrader(Trader trader) {
        traderRepository.save(trader);
    }

    public void deleteTrader(Long traderId) {
        if (!traderRepository.existsById(traderId)) {
            throw new IllegalStateException("Trader doesn'exist!");
        }
        traderRepository.deleteById(traderId);
    }

    @Transactional
    public void updateTrader(Long traderID, Float taxRate, Float taxAmount) {
        Optional<Trader> trader = traderRepository.findById(traderID);
        if (trader.isEmpty()) {
            throw new IllegalStateException("Trader doesn't exist!");
        }
        if (taxRate != null && taxRate > 0) {
            trader.get().setTaxRate(taxRate);
        }
        if (taxAmount != null && taxAmount > 0) {
            trader.get().setTaxAmount(taxAmount);
        }
    }
}
