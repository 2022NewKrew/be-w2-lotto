package domain.lotto;

import dto.LottoDTO;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoPrecondition.checkNumbers(numbers);
        this.numbers = numbers;
    }

    public LottoDTO getNumbers() {
        return new LottoDTO(numbers);
    }
}
