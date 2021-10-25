package com.taxation.trader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@ToString
@NoArgsConstructor
@Data
public class Trader {
    @Id
    @SequenceGenerator(
            name = "trader_seq",
            sequenceName = "trader_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trader_seq"
    )
    private Long traderId;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;

    public Trader(BigDecimal taxRate, BigDecimal taxAmount) {
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
    }
}
