package lotto.domain.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoInfo.*;

public class AutoLotto extends LottoGenerator {
    @Override
    public List<Integer> generateNumbers(List<Integer> inputNumbers) {
        List<Integer> lottoNums = IntStream.range(MIN_NUMBER.getValue(), MAX_NUMBER.getValue()).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNums);
        List<Integer> lottoTicket = lottoNums.subList(0, COUNT_OF_NUMBER.getValue());
        Collections.sort(lottoTicket);
        return lottoTicket;
    }
}