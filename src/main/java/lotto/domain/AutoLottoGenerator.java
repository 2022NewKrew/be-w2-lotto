package lotto.domain;

import lotto.DuplicationException;
import lotto.NumOfLottoNumbersMismatchException;
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

public class AutoLottoGenerator implements LottoGenerator {
    private final List<LottoNumber> randomLottoNumberList = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final long numOfAutoLottos;

    public AutoLottoGenerator(long numOfAutoLottos) {
        this.numOfAutoLottos = numOfAutoLottos;
    }

    public List<Lotto> generate() throws IllegalArgumentException {
        return Stream.generate(this::generateRandomLotto)
                .limit(numOfAutoLottos)
                .collect(Collectors.toList());
    }

    private @NotNull Lotto generateRandomLotto() throws DuplicationException, NumOfLottoNumbersMismatchException {
        List<LottoNumber> tmpList = new ArrayList<>(randomLottoNumberList);
        Collections.shuffle(tmpList);
        return new Lotto(tmpList.subList(0, NUM_OF_LOTTO_NUMBERS_IN_LOTTO));
    }
}
