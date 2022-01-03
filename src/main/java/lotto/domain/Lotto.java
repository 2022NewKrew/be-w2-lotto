package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoInfo.*;

public class Lotto {
    private final List<Integer> lottoTicket;

    public Lotto() {
        List<Integer> lottoNums = IntStream.range(MIN_NUMBER.getValue(), MAX_NUMBER.getValue()).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNums);
        lottoTicket = lottoNums.subList(0, COUNT_OF_NUMBER.getValue());
        Collections.sort(lottoTicket);
    }

    public int countMatchedNumber(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::contains).count();
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}