package domain;

public class WinningLottery {
    private static final String VALIDATE_NUMBER_BOUND_MESSAGE = "로또 번호는 1 ~ 45 사이여야 합니다.";
    private static final String VALIDATE_NUMBER_REPEAT_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lottery lottery;
    private final int bonusNumber;

    public WinningLottery(Lottery lottery, int bonusNumber) {
        validate(lottery, bonusNumber);
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lottery lottery, int bonusNumber) {
        validateNumberBound(bonusNumber);
        validateNumberRepeat(lottery, bonusNumber);
    }

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_BOUND_MESSAGE);
        }
    }

    private void validateNumberRepeat(Lottery lottery, int bonusNumber) {
        if (lottery.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_REPEAT_MESSAGE);
        }
    }

    public Lottery getLottery() {
        return lottery;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

