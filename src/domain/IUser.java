package domain;

import java.util.List;

public interface IUser {

    void purchase(int price, int numberOfManual, List<String> manualList);

    void lotteryDraw();

    void calculateProfit();
}