package lotto.domain;

import static lotto.controller.LottoSimulator.SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.DuplicationException;
import lotto.exception.IllegalLottoNumberException;
import lotto.exception.NumOfLottoNumbersMismatchException;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<String> manualLottoStringList;

    public ManualLottoGenerator(List<String> manualLottoStringList) {
        this.manualLottoStringList = manualLottoStringList;
    }

    public List<Lotto> generate() throws IllegalArgumentException {
        return manualLottoStringList.stream()
            .map(this::generateManualLotto)
            .collect(Collectors.toList());
    }

    private Lotto generateManualLotto(String lottoNumbers)
        throws IllegalLottoNumberException, DuplicationException, NumOfLottoNumbersMismatchException {
        return new Lotto(Arrays.stream(lottoNumbers.split(SEPARATOR))
            .map(s -> Integer.parseInt(s.trim()))
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }
}
