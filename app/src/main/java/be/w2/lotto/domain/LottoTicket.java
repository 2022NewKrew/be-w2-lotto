package be.w2.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static be.w2.lotto.domain.LottoNumber.LOTTO_NUMBER_LOWERBOUND;
import static be.w2.lotto.domain.LottoNumber.LOTTO_NUMBER_UPPERBOUND;
import static be.w2.lotto.domain.LottoTickets.LOTTO_TICKET_SIZE;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers
                .stream().map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public static LottoTicket newInstance() {
        List<LottoNumber> lottoNumbers = generateLottoNumbers();
        return new LottoTicket(lottoNumbers);
    }

    private static final List<Integer> entireLottoNumbers = IntStream
            .rangeClosed(LOTTO_NUMBER_LOWERBOUND, LOTTO_NUMBER_UPPERBOUND)
            .boxed()
            .collect(Collectors.toList());

    private static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(entireLottoNumbers);
        return entireLottoNumbers
                .stream().limit(LOTTO_TICKET_SIZE)
                .sorted()
                .collect(Collectors.toList())
                .stream().map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static final int LOTTO_TICKET_PRICE = 1000;
}
