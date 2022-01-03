package domain;

import exception.IllegalInputException;

import java.util.Arrays;

public enum Prize {
    FOURTH(5000, 3),
    THIRD(50000, 4),
    SECOND(1500000, 5),
    FIRST(2000000000, 6);

    private final int money;
    private final int correctAmount;

    Prize(int money, int correctAmount){
        this.money = money;
        this.correctAmount = correctAmount;
    }

    public int getMoney(){
        return money;
    }

    public int getCorrectAmount(){
        return correctAmount;
    }

    public static Prize createPrize(int correctAmount){
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getCorrectAmount() == correctAmount)
                .findFirst()
                .orElse(null);
    }
}
