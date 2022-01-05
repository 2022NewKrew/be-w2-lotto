package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Lotto {

    private final static String NUMBER_SIZE_ERROR_MESSAGE = "6개의 번호를 입력해주세요.";

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto purchaseLotto() {
        List<Integer> shuffledNumbers = RandomUtil.generateRandomNumbers();
        validate(shuffledNumbers);
        List<LottoNumber> lottoNumbers = shuffledNumbers.stream()
            .map(LottoNumber::new)
            .sorted()
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private static void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int countMatchNumber(List<LottoNumber> winningNumbers) {
        return (int) this.lottoNumbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }
}
