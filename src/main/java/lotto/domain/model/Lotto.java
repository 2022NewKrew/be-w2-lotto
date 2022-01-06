package lotto.domain.model;

import lotto.domain.constant.LottoMessage;

import java.util.*;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> allNumbers;

    static {
        List<Integer> range = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(range::add);
        allNumbers = Collections.unmodifiableList(range);
    }

    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>(allNumbers.size());
        numbers.addAll(allNumbers);
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);
        Collections.sort(numbers);
    }

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_OF_INPUT_NOT_MATCH_ERROR.toString());
        }
        numbers.forEach(this::verifyBounds);
        verifyDuplication(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    protected void verifyBounds(int value) throws IllegalArgumentException {
        if (1 > value || value > 45) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_OUT_OF_BOUND_ERROR.toString());
        }
    }

    private void verifyDuplication(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_DUPLICATED_ERROR.toString());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
