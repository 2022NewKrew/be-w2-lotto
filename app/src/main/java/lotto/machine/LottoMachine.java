package lotto.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final List<LottoNumber> numbers = new ArrayList<>(45);

    static {
        for (int i = 1; i <= 45; i++)
            numbers.add(LottoNumber.from(i));
    }

    public static Lotto generateLottoAuto() {
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList<>(numbers.subList(0, Lotto.LOTTO_NUMBERS_COUNT)));
    }

    public static Lotto generateLottoManually(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
