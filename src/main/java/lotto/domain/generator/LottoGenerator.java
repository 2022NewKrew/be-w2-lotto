package lotto.domain.generator;

import java.util.List;

public abstract class LottoGenerator {
    public abstract List<Integer> generateNumbers(List<Integer> inputNumbers);
}