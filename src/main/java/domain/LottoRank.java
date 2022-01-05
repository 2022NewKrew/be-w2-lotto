package domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0, "0개 일치 (0원)- "),
    ONE(1, 500, "1개 일치 (500원)- "),
    TWO(2, 1_000, "2개 일치 (1000원)- "),
    THREE(3, 5_000, "3개 일치 (5000원)- "),
    FOUR(4, 50_000, "4개 일치 (50000원)- "),
    FIFTH(5, 1_500_000, "5개 일치 (1500000원)- "),
    FIFTHWITHBONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원) - "),
    SIX(6, 2_000_000_000, "6개 일치 (2000000000원)- ");

    private final int countOfMatch;
    private final int money;
    private final String message;

    LottoRank(int countOfMatch, int money, String message) {
        this.countOfMatch = countOfMatch;
        this.money = money;
        this.message = message;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public static LottoRank valueOf(int matchedNumber, boolean bonus) {
        LottoRank lottoRank = Arrays.stream(LottoRank.values())
                .filter(i -> i.getCountOfMatch() == matchedNumber)
                .findAny()
                .orElse(MISS);

        if (lottoRank == FIFTH && bonus) {
            return FIFTHWITHBONUS;
        }
        return lottoRank;
    }
}
