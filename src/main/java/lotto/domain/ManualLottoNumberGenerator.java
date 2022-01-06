package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator implements LottoNumbersGenerator {

    public LottoNumbers generateLottoNumbers(String[] strings) {
        return LottoNumbers.from(
                Arrays.stream(strings)
                        .map(Integer::parseInt)
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet())
        );
    }
}
