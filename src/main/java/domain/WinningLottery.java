package domain;

public class WinningLottery {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lottery lottery;
    private final int bonusNumber;

    public WinningLottery(Lottery lottery, int bonusNumber) {
        this.lottery = lottery;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateNumberBound(bonusNumber);
        validateNumberRepeat(bonusNumber);
    }

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Error: 로또 번호는 1 ~ 45 사이여야 합니다.");
        }
    }

    private void validateNumberRepeat(int bonusNumber) {
        if (lottery.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("Error: 로또 번호는 중복될 수 없습니다.");
        }
    }

    public Lottery getLottery() {
        return lottery;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
