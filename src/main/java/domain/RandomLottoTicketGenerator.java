package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class RandomLottoTicketGenerator implements LottoTicketGenerator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.range(MIN_VALUE, MAX_VALUE + 1)
                .forEach(numbers::add);
    }

    private List<Integer> generateRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    @Override
    public LottoTicket generate(Set<Integer> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>();

        List<Integer> randomNumbers = generateRandomNumbers();
        for (int randomNumber : randomNumbers) {
            numbers.add(LottoNumber.from(randomNumber));
        }

        return new LottoTicket(numbers);
    }
}
