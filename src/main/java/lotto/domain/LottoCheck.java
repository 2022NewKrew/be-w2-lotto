package lotto.domain;

import java.util.List;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_OF_LOTTO_NUMBER;

public class LottoCheck {
    private final List<Integer> numbers;
    private final int bonusNum;

    LottoCheck(List<Integer> numbers, int bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public void checkWinningLottoNumbers() throws IllegalArgumentException {
        checkNumList();
        checkBonusNum();
    }

    private void checkNumList() throws IllegalArgumentException {
        checkNumDuplication();
        checkNumCount();
        for (Integer num : numbers) {
            checkNumRange(num);
        }
    }

    private void checkBonusNum() throws IllegalArgumentException {
        checkNumDuplication(bonusNum);
        checkNumRange(bonusNum);
    }

    private void checkNumRange(Integer num) throws IllegalArgumentException {
        if (num < 1 || num > MAX_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 범위의 로또 당첨 번호입니다!");
        }
    }

    private void checkNumDuplication() throws IllegalArgumentException{
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 로또 당첨 번호입니다!");
        }
    }

    private void checkNumDuplication(int num) throws IllegalArgumentException{
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("중복된 보너스 로또 당첨 번호입니다!");
        }
    }

    private void checkNumCount() throws IllegalArgumentException{
        if (numbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 개수의 로또 당첨 번호입니다!");
        }
    }
}
