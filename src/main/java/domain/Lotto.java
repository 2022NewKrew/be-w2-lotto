package domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer checkMatchCount(List<Integer> checkNumbers) {
        // TODO - 몇개의 번호가 일치하는지 확인
        return 6;
    }
}
