package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.*;

public final class LottoGenerator {

    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())
                .boxed().collect(Collectors.toList());
    }

    public static List<Integer> getLottoTicket() {
        List<Integer> copyLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(copyLottoNumbers);
        return copyLottoNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS.getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}
