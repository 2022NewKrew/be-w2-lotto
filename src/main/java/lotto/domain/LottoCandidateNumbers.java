package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoNumber;

public class LottoCandidateNumbers {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static LottoCandidateNumbers instance;

    private final List<LottoNumber> candidateNumbers;

    public static LottoCandidateNumbers instance() {
        if (instance == null) {
            instance = new LottoCandidateNumbers();
        }
        return instance;
    }

    private LottoCandidateNumbers() {
        candidateNumbers = IntStream.rangeClosed(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
            .boxed().map(LottoNumber::from).collect(Collectors.toList());
    }

    public List<LottoNumber> generateRandomNumbers() {
        Collections.shuffle(candidateNumbers);
        return candidateNumbers.stream().limit(LOTTO_NUMBER_SIZE)
            .sorted().collect(Collectors.toList());
    }
}
