package DTO;

public class ResultDTO {
    private int matchNum;
    private boolean isMatchBonus;
    private long price;
    private int numLotto;

    public ResultDTO(int matchNum, boolean isMatchBonus, long price, int numLotto) {
        this.matchNum = matchNum;
        this.isMatchBonus = isMatchBonus;
        this.price = price;
        this.numLotto = numLotto;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }

    public void setMatchBonus(boolean matchBonus) {
        isMatchBonus = matchBonus;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getNumLotto() {
        return numLotto;
    }

    public void setNumLotto(int numLotto) {
        this.numLotto = numLotto;
    }
}
