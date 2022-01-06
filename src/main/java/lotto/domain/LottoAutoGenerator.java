package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.Lotto.NUM_OF_LOTTO_NUMBERS_IN_LOTTO;
import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;

public class LottoAutoGenerator {
    private final List<LottoNumber> randomLottoNumberList = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public List<Lotto> getRandomLottos(long numOfLottos) throws IllegalArgumentException {
        return Stream.generate(() -> new Lotto(getRandomLottoNumbers()))
                .limit(numOfLottos)
                .collect(Collectors.toList());
    }

    private @NotNull List<LottoNumber> getRandomLottoNumbers() throws IllegalArgumentException {
        List<LottoNumber> tmpList = new ArrayList<>(randomLottoNumberList);
        Collections.shuffle(tmpList);
        return new ArrayList<>(tmpList.subList(0, NUM_OF_LOTTO_NUMBERS_IN_LOTTO));
    }
}
