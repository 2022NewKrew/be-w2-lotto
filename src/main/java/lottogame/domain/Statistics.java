package lottogame.domain;

public class Statistics {
    private Results results;
    private RateOfReturn rateOfReturn;

    Statistics(Results results, RateOfReturn rateOfReturn) {
        this.results = results;
        this.rateOfReturn = rateOfReturn;
    }

    public Results getResults() {
        return results;
    }

    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
    }
}
