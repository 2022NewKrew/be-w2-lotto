package domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final Random random = new Random();
    private static final int MAXIMUM_VALUE = 46;
    private static final int MINIMUM_VALUE = 1;
    private static final int PICK_LOTTO = 6;
    private static final List<Integer> ALL_POSSIBLE_LOTTO_NUMBERS = IntStream.range(MINIMUM_VALUE, MAXIMUM_VALUE)
            .boxed()
            .collect(Collectors.toList());

    public LottoRepository createAutoLottos(int purchasedLottoNumbers) {
        List<Lotto> autuLottos = Stream.generate(this::createAutoLotto)
                .limit(purchasedLottoNumbers)
                .collect(Collectors.toList());
        return new LottoRepository(autuLottos);
    }

    private Lotto createAutoLotto() {
        return new Lotto(createAutoLottoNumber());
     }

    private List<Integer> createAutoLottoNumber() {
        Collections.shuffle(ALL_POSSIBLE_LOTTO_NUMBERS);
        return ALL_POSSIBLE_LOTTO_NUMBERS.stream()
                .limit(PICK_LOTTO)
                .sorted()
                .collect(Collectors.toList());
    }
}
