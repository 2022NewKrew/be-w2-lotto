package domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final Random random = new Random();
    private static final int MAXIMUM_VALUE = 44;

    public Lotto createAutoLotto() {
        Lotto lotto = new Lotto(createAutoLottoNumber());
//        System.out.println(lotto.getLotto());
        return lotto;
    }

    private List<Integer> createAutoLottoNumber() {
        List<Integer> autoLottoNumber = Stream.generate(() -> random.nextInt(MAXIMUM_VALUE) + 1)
                .limit(6)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        while (autoLottoNumber.size() < 6) {
            autoLottoNumber.add(random.nextInt(MAXIMUM_VALUE) + 1);
            autoLottoNumber.stream().sorted();
        }
//        autoLottoNumber.stream().sorted();
        return autoLottoNumber;
    }
}
