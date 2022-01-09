package lotto.domain;

import lotto.configure.LottoConfigure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validate();
    }

    public Optional<List<Integer>> getNumbers() {
        return Optional.ofNullable(numbers);
    }

    private void validate(){
        if (numbers.size() != LottoConfigure.NUMBERS_SIZE) throw new IllegalArgumentException();
        for (int i = 0; i < LottoConfigure.NUMBERS_SIZE; i++){
            if (numbers.get(i) < LottoConfigure.MIN_NUMBER || LottoConfigure.MAX_NUMBER < numbers.get(i)) throw new IllegalArgumentException();
        }
    }

}
