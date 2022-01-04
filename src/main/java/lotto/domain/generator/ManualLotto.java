package lotto.domain.generator;

import java.util.List;

public class ManualLotto extends LottoGenerator{
    @Override
    public List<Integer> generateNumbers(List<Integer> inputNumbers) {
        return inputNumbers;
    }
}