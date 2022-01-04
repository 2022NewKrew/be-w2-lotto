package carrot.ez.lotto;

import java.util.Arrays;

public enum Rank {
    Fifth(3, 5000, "%d개 일치 (%d원)- %d개\n"),
    Fourth(4, 50000, "%d개 일치 (%d원)- %d개\n"),
    Third(5, 1500000, "%d개 일치 (%d원)- %d개\n"),
    Second(5, 30000000, "%d개 일치, 보너스 볼 일치(%d원)- %d개\n"),
    First(6, 2000000000, "%d개 일치 (%d원)- %d개\n"),
    None(0, 0, "");

    private final int correctNum;
    private final long price;
    private final String stringFormat;
    Rank(int correctNum, long price, String stringFormat) {
        this.correctNum = correctNum;
        this.price = price;
        this.stringFormat = stringFormat;
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

    public String getStringFormat() {
        return stringFormat;
    }
}