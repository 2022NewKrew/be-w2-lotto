package dto;

import domain.lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoDTO {
    private final List<Integer> numbers;

    public LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDTO getLottoDTO(Lotto lotto) {
        return new LottoDTO(lotto.getNumbers());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
