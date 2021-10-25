package com.taxation.trader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraderConfig {
    @Bean
    CommandLineRunner commandLineRunner(TraderRepository traderRepository) {
        return args -> {
            Trader firstTrader = new Trader(0.1F, 2.0F);
            traderRepository.save(firstTrader);
        };
    }
}
