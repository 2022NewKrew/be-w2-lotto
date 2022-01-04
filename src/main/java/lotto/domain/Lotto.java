package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.Constants.*;
import static lotto.util.RandomNumberCreator.createRandomNumbers;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if(!isValidLottoNumbers(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_ERROR_MESSAGE);
        }
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        return new Lotto(randomNumbers);
    }

    private boolean isValidLottoNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = numbers.stream()
                .filter(num -> LOTTO_START_NUMBER <= num && num <= LOTTO_END_NUMBER)
                .collect(Collectors.toSet());

        return numberSet.size() == NUM_OF_WINNING_NUMBERS;
    }

    /*
    현재 로또 번호 안에 당첨 번호가 몇 개 들어있는지 반환하는 메서드
     */
    public int getResult(LottoGame lottoGame) {
        int matched = (int) lottoGame.getWinningNumbers().stream()
                                                                    .filter(this.numbers::contains)
                                                                    .count();

        if(matched == 5) {
            return matched + this.hitBonusNumber(lottoGame.getBonusNumber());
        }

        if(matched == 6) {
            return 7;
        }
        return matched;
    }

    private int hitBonusNumber(int bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
