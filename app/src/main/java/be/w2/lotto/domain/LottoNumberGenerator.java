package be.w2.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static be.w2.lotto.domain.LottoNumber.LOTTO_NUMBER_LOWERBOUND;
import static be.w2.lotto.domain.LottoNumber.LOTTO_NUMBER_UPPERBOUND;
import static be.w2.lotto.domain.LottoTickets.LOTTO_TICKET_SIZE;

public class LottoNumberGenerator {
    private static final List<Integer> entireLottoNumbers = IntStream
            .rangeClosed(LOTTO_NUMBER_LOWERBOUND, LOTTO_NUMBER_UPPERBOUND)
            .boxed()
            .collect(Collectors.toList());

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(entireLottoNumbers);
        return entireLottoNumbers.stream()
                .limit(LOTTO_TICKET_SIZE)
                .sorted()
                .collect(Collectors.toList()).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
