package view;

import domain.Lottery;
import domain.Result;

import java.util.List;

public interface OutputView {
    void printBoughtLotteries(List<Lottery> manualBoughtLotteries, List<Lottery> autoBoughtLotteries);

    void printResult(Result result);
}
