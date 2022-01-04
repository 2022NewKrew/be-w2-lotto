package lottogame.domain;

import java.util.List;

public class Results {
    private List<Result> results;

    Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public int sumOfResults() {
        int sum = 0;
        for (var result : results) {
            sum += result.getPrizeMoney() * result.getCountOfTickets();
        }
        return sum;
    }
}
