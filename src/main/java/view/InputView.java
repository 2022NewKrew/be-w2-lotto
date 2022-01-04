package view;

import java.util.Set;

public interface InputView {
    int LOTTERY_UNIT_PRICE = 1000;

    long getLotteryBoughtPrice();

    Set<Integer> getLotteryNumberList();
}
