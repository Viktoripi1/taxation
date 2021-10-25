package com.taxation.trader;

import javax.persistence.*;

@Entity
@Table
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
    private float taxRate;
    private float taxAmount;

    public Trader() {
    }

    public Trader(float taxRate, float taxAmount) {
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
    }

    public Long getTraderId() {
        return traderId;
    }

    public void setTraderId(Long traderId) {
        this.traderId = traderId;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }


    @Override
    public String toString() {
        return "Trader{" +
                "traderId=" + traderId +
                ", taxRate=" + taxRate +
                '}';
    }

}
