package domain.match;

public enum LottoRank {
    NONE(0, "꽝"),
    FIFTH(5000, "3개 일치"),
    FORTH(50000, "4개 일치"),
    THIRD(1500000, "5개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(2000000000, "6개 일치");

    private final int prizeMoney;
    private final String message;

    LottoRank(int prizeMoney, String message) {
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getPrize() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static int getNumOfRanks() {
        return 5;
    }
}