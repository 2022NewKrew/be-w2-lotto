package view;

import java.util.List;
import java.util.Set;

public interface InputView {
    long getLotteryBoughtPrice();

    Set<Integer> getWinningLotteryNumbers();

    int getBonusNumber();

    long getManualBoughtCount(long limit);

    List<Set<Integer>> getManualBoughtLotteriesNumbers(long count);
}
