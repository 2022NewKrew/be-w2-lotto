package view;

import java.util.List;

public interface InputView {
    int LOTTERY_UNIT_PRICE = 1000;

    long getLotteryBoughtPrice();

    List<Integer> getLotteryNumberList();
}
