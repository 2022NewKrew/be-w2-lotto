package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            allLottoNumbers.add(new LottoNumber(number));
        }
    }

    private LottoStore() {
    }

    private static Lotto createLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }

    public static Lottos purchase(long lottoCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoCount; i++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }

    public static Lotto purchase(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(allLottoNumbers.stream()
                .filter(number -> lottoNumbers.contains(number))
                .collect(Collectors.toList()));
        return lotto;
    }
}
