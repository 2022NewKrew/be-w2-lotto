package domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private static final Random random = new Random();
    private static final int MAXIMUM_VALUE = 46;
    private static final int MINIMUM_VALUE = 1;
    private static final int PICK_LOTTO = 6;
    private static final List<Integer> LOTTO_BALLS = IntStream.range(MINIMUM_VALUE, MAXIMUM_VALUE)
            .boxed()
            .collect(Collectors.toList());

    public LottoRepository createAutoLottos(int purchasedLottoNumbers) {
        List<Lotto> autoLottos = Stream.generate(this::createAutoLotto)
                .limit(purchasedLottoNumbers)
                .collect(Collectors.toList());
        return new LottoRepository(autoLottos);
    }

    private Lotto createAutoLotto() {
        return new Lotto(createAutoLottoNumber());
     }

    private Set<Integer> createAutoLottoNumber() {
        Collections.shuffle(LOTTO_BALLS);
        return LOTTO_BALLS.stream()
                .limit(PICK_LOTTO)
                .collect(Collectors.toSet());
    }
}
