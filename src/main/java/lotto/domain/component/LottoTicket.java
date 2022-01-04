package lotto.domain.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        validateLottoNumberCount(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    private void validateLottoNumberCount(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호의 수는 최소" + LOTTO_NUMBERS_COUNT + "개 입력해야합니다.");
        }
    }
}
