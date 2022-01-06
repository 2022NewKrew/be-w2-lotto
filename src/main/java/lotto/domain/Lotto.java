package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int COUNT_OF_WINNING_NUMBERS = 6;
    public static final int MAX_NUMBER_OF_LOTTO = 45;
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = Collections.unmodifiableList(makeAutomaticLottoNumbers());
    }

    public Lotto(List<Integer> manualLottoNumbers) {
        validateLottoNumbers(manualLottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(manualLottoNumbers);
    }

    private List<Integer> makeAutomaticLottoNumbers() {
        List<Integer> lottoBasicNumbers = makeLottoBasicNumbers();
        Collections.shuffle(lottoBasicNumbers);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_WINNING_NUMBERS; i++) {
            numbers.add(lottoBasicNumbers.get(i));
        }
        Collections.sort(numbers);

        return numbers;
    }

    private void validateLottoNumbers(List<Integer> manualLottoNumbers) {

        if (!isValidLottoNumbers(manualLottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45 사이여야 합니다.");
        }

        if (!isValidLottoNumbersCount(manualLottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 6개가 입력이 되어야 합니다.");
        }
    }

    private boolean isValidLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .allMatch(lottoNumber -> lottoNumber <= 45 && lottoNumber >= 1);
    }

    private boolean isValidLottoNumbersCount(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == COUNT_OF_WINNING_NUMBERS;
    }

    private List<Integer> makeLottoBasicNumbers() {
        List<Integer> basicLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER_OF_LOTTO; i++) {
            basicLottoNumbers.add(i);
        }

        return basicLottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoWinningRating getWinningRating(List<Integer> winningNumbers, int bonusBallNumber) {

        int matchCount = Math.toIntExact(winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count());

        return LottoWinningRating.getWinningRating(matchCount, hasBonusBall(matchCount, bonusBallNumber));
    }

    private boolean hasBonusBall(int matchCount, int bonusBallNumber) {
        if (matchCount != 5) {
            return false;
        }

        return lottoNumbers.contains(bonusBallNumber);
    }

}
