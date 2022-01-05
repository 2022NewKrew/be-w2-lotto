package com.kakaocorp.lotto.dto;

import com.kakaocorp.lotto.enums.Grade;

import java.util.Map;

public class ResultResponse {

    private double rateOfReturn;
    private Map<Grade, Integer> results;

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Grade, Integer> getResults() {
        return results;
    }

    public void setResults(Map<Grade, Integer> results) {
        this.results = results;
    }
}
