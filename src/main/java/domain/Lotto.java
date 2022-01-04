package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import util.RandomUtil;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto purchaseLotto() {
        List<Integer> shuffledNumbers = RandomUtil.generateRandomNumbers();

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBERS_SIZE; i++) {
            lottoNumbers.add(new LottoNumber(shuffledNumbers.get(i)));
        }
        lottoNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
