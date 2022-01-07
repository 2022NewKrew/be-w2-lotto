package DTO;

public class ResultDTO {
    private final int matchNum;
    private final boolean isMatchBonus;
    private final long price;
    private final int numLotto;

    public ResultDTO(int matchNum, boolean isMatchBonus, long price, int numLotto) {
        this.matchNum = matchNum;
        this.isMatchBonus = isMatchBonus;
        this.price = price;
        this.numLotto = numLotto;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }

    public long getPrice() {
        return price;
    }

    public int getNumLotto() {
        return numLotto;
    }
}
