package domain;

import common.LottoWinningStatus;

import java.util.List;

public class Lotto {

    protected static final int LOTTO_END_NUMBER = 45;
    protected static final int LOTTO_START_NUMBER = 1;

    public Lotto() {}

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    protected List<Integer> numbers;

    protected LottoWinningStatus status = LottoWinningStatus.NORMAL;

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoWinningStatus getStatus() {
        return status;
    }

    public void updateStatus(List<Integer> winningNumbers, int winningBonusNumber) {
        this.status = getWinningStatus(getCountWinning(winningNumbers), hasBonusNumber(winningBonusNumber));
    }

    protected void validationOfkNumbers() {

        hasSixSizeOfNumbers();
        hasValidNumbers();
    }

    private LottoWinningStatus getWinningStatus(int count, boolean bonusCheck) {

        if (count == 3) {
            return LottoWinningStatus.TREE_WINNING;
        }

        if (count == 4) {
            return LottoWinningStatus.FOUR_WINNING;
        }

        if (count == 5 && bonusCheck) {
            return LottoWinningStatus.FIVE_AND_BONUS_WINNING;
        }

        if (count == 5 && !bonusCheck) {
            return LottoWinningStatus.FIVE_WINNING;
        }

        if (count == 6) {
            return LottoWinningStatus.SIX_WINNING;
        }

        return LottoWinningStatus.BANG;

    }

    private void hasSixSizeOfNumbers() {
        if(numbers.size() != 6) throw new IllegalArgumentException("6자리 숫자가 아닙니다.");
    }

    private void hasValidNumbers() {
        for (int num : numbers) {
            if (num <LOTTO_START_NUMBER || num > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("1~45숫자를 입력해주세요!");
            }
        }
    }

    private int getCountWinning(List<Integer> winningNumbers) {
        int count = 0;

        for (int number : this.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(int winningBonusNumber) {
        return this.getNumbers().contains(winningBonusNumber);
    }

}
