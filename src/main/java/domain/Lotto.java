package domain;

import common.LottoWinningStatus;

import java.util.List;

public class Lotto {
    protected static int LOTTO_END_NUMBER = 45;
    protected static int LOTTO_START_NUMBER = 1;

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

        // TODO: 순서에 의해서 bonusCheck는 제거해도 되지만 순서 바꿀씨 치명적이므로 명시적으로 표현하고 있음. (향후 리뷰 후 수정 예정)
        if (count == 5 && !bonusCheck) {
            return LottoWinningStatus.FIVE_WINNING;
        }

        if (count == 6) {
            return LottoWinningStatus.SIX_WINNING;
        }

        return LottoWinningStatus.BANG;

    }

    private void validationOfkNumbers() {
        for (int num : numbers) {
            if (LOTTO_START_NUMBER < num || num > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("1~45숫자를 입력해주세요!");
            }
        }
    }

    private int getCountWinning(List<Integer> winningNumbers, int winningBonusNumber) {
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


    public void updateStatus(List<Integer> winningNumbers, int winningBonusNumber) {
        this.status = getWinningStatus(getCountWinning(winningNumbers, winningBonusNumber), hasBonusNumber(winningBonusNumber));
    }
}
