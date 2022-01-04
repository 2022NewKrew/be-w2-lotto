package step2.dto;

import step2.domain.Lotto;

import java.util.List;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static LottoDto of(Lotto lotto){
        return new LottoDto(lotto.getNumbers());
    }
}
