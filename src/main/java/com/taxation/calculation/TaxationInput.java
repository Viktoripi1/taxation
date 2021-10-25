package com.taxation.calculation;

public class TaxationInput {

    private long traderID;
    private float playedAmount;
    private float odd;

    public TaxationInput(Long traderID, float playedAmount, float odd) {
        this.traderID = traderID;
        this.playedAmount = playedAmount;
        this.odd = odd;
    }

    public long getTraderID() {
        return traderID;
    }

    public void setTraderID(long traderID) {
        this.traderID = traderID;
    }

    public float getPlayedAmount() {
        return playedAmount;
    }

    public void setPlayedAmount(float playedAmount) {
        this.playedAmount = playedAmount;
    }

    public float getOdd() {
        return odd;
    }

    public void setOdd(float odd) {
        this.odd = odd;
    }

    @Override
    public String toString() {
        return "incoming{" +
                "traderID:" + traderID +
                ", playedAmount:" + playedAmount +
                ", odd:" + odd +
                '}';
    }

}
