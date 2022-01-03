package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRow {

    private final List<Integer> lottoNumbers;
    public static final Integer NUMBER_OF_WINNING_NUMBERS = 6;
    public static final Integer MAX_SIZE_OF_LOTTO = 45;

    public LottoRow() {
        this.lottoNumbers = makeLottoNumbers();
    }

    private List<Integer> makeLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> lottoBasicNumbers = makeLottoBasicNumbers();
        Collections.shuffle(lottoBasicNumbers);
        for (int i = 0; i < NUMBER_OF_WINNING_NUMBERS; i++) {
            numbers.add(lottoBasicNumbers.get(i));
        }
        Collections.sort(numbers);

        return numbers;
    }

    private List<Integer> makeLottoBasicNumbers() {
        List<Integer> basicLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= MAX_SIZE_OF_LOTTO; i++) {
            basicLottoNumbers.add(i);
        }

        return basicLottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoWinningRating getWinningRating(List<Integer> winningNumbers) {

        int matchCount = Math.toIntExact(winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count());

        return LottoWinningRating.getWinningRating(matchCount);
    }
}
