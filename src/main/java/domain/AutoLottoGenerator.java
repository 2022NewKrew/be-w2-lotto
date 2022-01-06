package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.*;

public final class AutoLottoGenerator implements LottoGenerator{

    private final List<Integer> lottoNumbers;

    public AutoLottoGenerator() {
        this.lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())
                .boxed().collect(Collectors.toList());
    }

    @Override
    public LottoTicket getLottoTicket() {
        List<Integer> copyLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(copyLottoNumbers);
        return new LottoTicket(copyLottoNumbers.subList(0, NUMBER_OF_LOTTO_NUMBERS.getValue()));
    }
}
