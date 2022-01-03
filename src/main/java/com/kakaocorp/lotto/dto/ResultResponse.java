package com.kakaocorp.lotto.dto;

public class ResultResponse {

    private int rateOfReturn;
    private int[] result;

    public int getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(int rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }
}
