package domain.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class Numbers {
    private static final int NUMBER_DOMAIN_START = 1;
    private static final int NUMBER_DOMAIN_END = 45;
    private static final List<Integer> NUMBERS_DOMAIN = IntStream.rangeClosed(NUMBER_DOMAIN_START, NUMBER_DOMAIN_END).collect(ArrayList::new, List::add, List::addAll);
    private static final int NUMBERS_LENGTH = 6;

    public List<Integer> getNumbers() {
        return numbers;
    }

    private final List<Integer> numbers;

    Numbers(Random random) {
        Collections.shuffle(NUMBERS_DOMAIN, random);
        numbers = new ArrayList<>(NUMBERS_DOMAIN.subList(0, NUMBERS_LENGTH));
        Collections.sort(numbers);
    }

    Numbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        for (var number : numbers) {
            validateNumberDomain(number);
            this.numbers.add(number);
        }
        Collections.sort(this.numbers);
    }

    private void validateNumberDomain(int number) {
        if (!NUMBERS_DOMAIN.contains(number)) {
            throw new IllegalArgumentException("number " + number + " is out of Number Domain.");
        }
    }
}
