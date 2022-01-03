package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    private static final int PICK_UP_POSITION = 0;

    private final List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = initLotto();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> initLotto() {
        List<Integer> candidateNumbers = IntStream.range(LOTTO_NUMBER_START, LOTTO_NUMBER_END + 1)
            .boxed()
            .collect(Collectors.toList());

        return makeLottoNumbersFromCandidates(candidateNumbers);
    }

    private List<Integer> makeLottoNumbersFromCandidates(List<Integer> candidateNumbers) {
        return IntStream.range(0, LOTTO_NUMBER_SIZE)
            .map(x -> shuffleAndPick(candidateNumbers)).boxed()
            .sorted()
            .collect(Collectors.toList());
    }

    private int shuffleAndPick(List<Integer> numbers) {
        Collections.shuffle(numbers);
        int pickedValue = numbers.get(PICK_UP_POSITION);
        numbers.remove(PICK_UP_POSITION);
        return pickedValue;
    }
}
