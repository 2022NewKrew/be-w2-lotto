package domain;

public enum LottoResultType {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchNumberCount;
    private final int money;

    LottoResultType(int matchNumberCount, int money) {
        this.matchNumberCount = matchNumberCount;
        this.money = money;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getMoney() {
        return money;
    }
}
