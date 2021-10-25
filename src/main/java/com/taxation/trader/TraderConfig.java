package com.taxation.trader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TraderConfig {
    @Bean
    CommandLineRunner commandLineRunner(TraderRepository traderRepository) {
        return args -> {
            Trader firstTrader = new Trader(new BigDecimal("0.1"), new BigDecimal("2.0"));
            traderRepository.save(firstTrader);
        };
    }
}
