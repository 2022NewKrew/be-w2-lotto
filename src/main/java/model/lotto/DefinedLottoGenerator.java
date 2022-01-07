package model.lotto;

import model.lotto.number.LottoNumber;
import utility.NullChecker;

import java.util.List;
import java.util.stream.Collectors;

public class DefinedLottoGenerator{

    public static List<LottoNumber> generate(List<Integer> numbers) {
        NullChecker.checkNotNull(numbers);

        return numbers
                .stream()
                .map(number -> LottoNumber.valueOf(number))
                .collect(Collectors.toList());
    }
}
