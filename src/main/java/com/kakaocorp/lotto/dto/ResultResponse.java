package com.kakaocorp.lotto.dto;

import java.util.Arrays;
import java.util.List;

public class ResultResponse {

    public static final List<Integer> winningMoneyList = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);

    private double rateOfReturn;
    private List<Integer> results;

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(int rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}
