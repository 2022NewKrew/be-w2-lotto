package domain;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;

    public Winning(List<Integer> numbers) {
        if (numbers.size() != LottoGenerator.NUMBER_COUNT)
            throw new IllegalArgumentException("로또 당첨번호의 입력이 올바르지 않습니다.");
        
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
