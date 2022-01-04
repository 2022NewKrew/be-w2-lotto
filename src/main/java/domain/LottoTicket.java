package domain;

import java.util.Collections;
import java.util.List;

public final class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
