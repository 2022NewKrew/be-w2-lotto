package lotto.domain.helper;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.model.LottoNumber;

public class LottoNumberHelper {

    public static List<LottoNumber> convertNumbersToLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::from).collect(Collectors.toList());
    }
}
