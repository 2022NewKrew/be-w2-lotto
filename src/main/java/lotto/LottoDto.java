package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 45;
    public final static int NUMBERS_SIZE = 6;
    public final static int LOTTO_PRICE = 1000;

    private List<Integer> numbers;

    public LottoDto(Lotto source) {
        numbers = source.getNumbers().stream().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
