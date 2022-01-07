package step4.service.domain;

import step4.util.Validator;

import java.util.List;

public abstract class Lotto {

    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNum(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    protected void checkLottoNum(List<Integer> numbers){
        Validator.checkLottoNum(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
