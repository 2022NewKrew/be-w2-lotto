package be.w2.lotto.result;

public class Report {
    private int investment;
    private int revenue;
    private double yield;

    public Report(int investment, int revenue) {
        this.investment = investment;
        this.revenue = revenue;
        this.yield = calculateYield();
    }

    public double getYield() {
        return yield;
    }

    private double calculateYield() {
        return ((double) (revenue - investment) / investment) * 100;
    }
}
