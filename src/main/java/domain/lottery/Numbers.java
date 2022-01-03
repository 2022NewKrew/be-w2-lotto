package domain.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class Numbers {
    final List<Integer> numbers;
    final static int NUMBER_DOMAIN_START = 1;
    final static int NUMBER_DOMAIN_END = 45;
    final static List<Integer> NUMBERS_DOMAIN = IntStream.range(NUMBER_DOMAIN_START, NUMBER_DOMAIN_END + 1).collect(ArrayList::new, List::add, List::addAll);
    final static int NUMBERS_LENGTH = 6;

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
