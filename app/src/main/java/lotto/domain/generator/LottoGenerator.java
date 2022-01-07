package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import java.util.ArrayList;
import java.util.List;

public interface LottoGenerator {
    List<LottoNumber> numbers = new ArrayList<>(LottoNumber.MAX_NUMBER);

    Lotto generate();

    static void initNumbers() {
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++)
            numbers.add(LottoNumber.from(i));
    }
}
