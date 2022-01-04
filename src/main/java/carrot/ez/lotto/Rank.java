package carrot.ez.lotto;

import java.util.Arrays;

public enum Rank {
    Fifth(3, 5000, false),
    Fourth(4, 50000, false),
    Third(5, 1500000, false),
    Second(5, 30000000, true),
    First(6, 2000000000, false),
    None(0, 0, false);

    private final int correctNum;
    private final long price;
    private final boolean bonus;
    Rank(int correctNum, long price, boolean bonus) {
        this.correctNum = correctNum;
        this.price = price;
        this.bonus = bonus;
    }

    public static Rank of(int correctNum, boolean bonus) {
        Rank result = Arrays.stream(Rank.values())
                .filter(rank -> rank.correctNum == correctNum)
                .findAny()
                .orElse(None);

        if (result.correctNum == 5) {
            return bonus ? Rank.Second : Rank.Third;
        }
        return result;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public long getPrice() {
        return price;
    }
}