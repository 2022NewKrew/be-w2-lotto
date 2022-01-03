package dto;

import java.util.Collections;
import java.util.List;

public class LottoDTO {
    private final List<Integer> numbers;

    public LottoDTO (List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
