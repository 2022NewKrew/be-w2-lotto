package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_SIZE = 6;

    private List<Integer> lottoNumbers;

    public LottoTicket() {
        createLottoTicket();
    }

    private void createLottoTicket() {
        List<Integer> randomLottoNumbers = randomLottoNumbers();
        lottoNumbers = (randomLottoNumbers.subList(0, MAX_LOTTO_SIZE).stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    private List<Integer> randomLottoNumbers() {
        List<Integer> randomLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomLottoNumbers);
        return randomLottoNumbers;
    }

    public int getLottoMatchCount(List<Integer> winningNumbers) {
        int result = 0;
        for (Integer winningNumber : winningNumbers) {
            result = getResultCount(result, winningNumber);
        }
        return result;
    }

    private int getResultCount(int result, int winningNumber) {
        if (hasWinningNumber(winningNumber)) {
            return result + 1;
        }
        return result;
    }

    private Boolean hasWinningNumber(int winningNumber) {
        return lottoNumbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
