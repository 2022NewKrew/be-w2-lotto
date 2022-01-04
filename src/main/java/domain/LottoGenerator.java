package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
        private static final int LOTTO_SIZE = 6;
        private static final List<Integer> fixedNumbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());

        public static Lotto generateLotto() {
                Collections.shuffle(fixedNumbers);
                return new Lotto(new ArrayList<>(fixedNumbers.subList(0, LOTTO_SIZE)));
        }
}
