package lotto.domain.model;

import lotto.domain.constant.LottoMessage;

import java.util.*;
import java.util.stream.LongStream;

public class Lotto {
    private static final List<Long> allNumbers;

    static {
        List<Long> range = new ArrayList<>();
        LongStream.rangeClosed(1, 45).forEach(range::add);
        allNumbers = Collections.unmodifiableList(range);
    }

    private List<Long> numbers;

    public Lotto() {
        numbers = new ArrayList<>(allNumbers.size());
        numbers.addAll(allNumbers);
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);
        Collections.sort(numbers);
    }

    public Lotto(List<Long> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_OF_INPUT_NOT_MATCH_ERROR.toString());
        }
        numbers.forEach(this::verifyBounds);
        verifyDuplication(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    protected void verifyBounds(Long value) throws IllegalArgumentException {
        if (1 > value || value > 45) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_OUT_OF_BOUND_ERROR.toString());
        }
    }

    private void verifyDuplication(List<Long> numbers) throws IllegalArgumentException {
        Set<Long> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_DUPLICATED_ERROR.toString());
        }
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
