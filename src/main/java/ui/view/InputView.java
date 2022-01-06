package ui.view;

import java.util.List;
import java.util.Set;

public interface InputView {

    long getBudget();

    Set<Integer> getLotteryResultNumbers();

    int getLotteryResultBonusNumber();

    int getManualIssueLotteryCount(int limit);

    List<Set<Integer>> getManualIssueLotteriesNumbers(int count);
}
