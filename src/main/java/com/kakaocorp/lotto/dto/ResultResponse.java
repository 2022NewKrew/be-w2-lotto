package com.kakaocorp.lotto.dto;

import java.util.Arrays;
import java.util.List;

public class ResultResponse {

    private int rateOfReturn;
    private List<Integer> result;
    public static final List<Integer> winningMoneyList = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    public int getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(int rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
