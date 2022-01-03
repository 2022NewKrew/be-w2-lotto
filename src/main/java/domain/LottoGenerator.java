package domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final Random random = new Random();
    private static final int MAXIMUM_VALUE = 44;

    public List<Lotto> createAutoLottos(int purchasedLottoNumbers) {
        return Stream.generate(this::createAutoLotto)
                .limit(purchasedLottoNumbers)
                .collect(Collectors.toList());
    }

    private Lotto createAutoLotto() {
        return new Lotto(createAutoLottoNumber());
     }

    private List<Integer> createAutoLottoNumber() {
        List<Integer> autoLottoNumber = Stream.generate(() -> random.nextInt(MAXIMUM_VALUE) + 1)
                .limit(6)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        while (autoLottoNumber.size() < 6) {
            if (autoLottoNumber.contains(random.nextInt(MAXIMUM_VALUE)) {
                continue;
            } autoLottoNumber.add(random.nextInt(MAXIMUM_VALUE) + 1);
            Collections.sort(autoLottoNumber);
        }
        return autoLottoNumber;
    }
}
