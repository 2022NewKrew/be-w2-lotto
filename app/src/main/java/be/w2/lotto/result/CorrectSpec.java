package be.w2.lotto.result;

public class CorrectSpec {
    private int numOfCorrect;
    private boolean isContainBonus;

    public CorrectSpec(int numOfCorrect, boolean isContainBonus) {
        this.numOfCorrect = numOfCorrect;
        this.isContainBonus = isContainBonus;
    }

    public int getNumOfCorrect() {
        return numOfCorrect;
    }

    public boolean isContainBonus() {
        return isContainBonus;
    }
}
