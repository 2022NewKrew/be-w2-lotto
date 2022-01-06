package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<String> manualLottoStringList;

    public ManualLottoGenerator(List<String> manualLottoStringList) {
        this.manualLottoStringList = manualLottoStringList;
    }

    public List<Lotto> generate() {
        return manualLottoStringList.stream()
                .map(this::generateManualLotto)
                .collect(Collectors.toList());
    }

    private Lotto generateManualLotto(String lottoNumbers) throws IllegalArgumentException {
        return new Lotto(Arrays.stream(lottoNumbers.split(SEPARATOR))
                .map(s -> Integer.parseInt(s.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
