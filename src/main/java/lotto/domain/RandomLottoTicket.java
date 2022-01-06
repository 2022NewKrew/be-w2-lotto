package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoTicket extends LottoTicket {
    private static final List<LottoNumber> ALL_NUMBERS = IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE + 1).mapToObj(LottoNumber::new).collect(Collectors.toList());

    public RandomLottoTicket() {
        super(createRandomLottoNumbers());
    }

    private static LottoNumbers createRandomLottoNumbers() {
        Collections.shuffle(ALL_NUMBERS);
        return new LottoNumbers(new ArrayList<>(ALL_NUMBERS.subList(0, LottoNumbers.SIZE_OF_LOTTO_NUMBERS)));
    }

}
