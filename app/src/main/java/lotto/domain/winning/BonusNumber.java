package lotto.domain.winning;

public class BonusNumber {

    private int bonus;

    public BonusNumber(int bonus) {
        this.bonus = bonus;
    }

    public boolean bonusNumberIsIncluded(int num) {
        return bonus == num;
    }

}
