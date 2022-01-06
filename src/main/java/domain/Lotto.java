package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Lotto {

    private final static String NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 6개의 번호를 입력해주세요.";
    private final static String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복되지 않게 번호를 입력해주세요.";

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto purchaseManualLotto(List<Integer> manaulNumbers) {
        validate(manaulNumbers);
        List<LottoNumber> lottoNumbers = manaulNumbers.stream()
            .map(LottoNumber::new)
            .sorted()
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public static Lotto purchaseAutoLotto() {
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
        Set<Integer> lottoNumbersForCheckDuplication = new HashSet<>(lottoNumbers);
        if(lottoNumbers.size()!=lottoNumbersForCheckDuplication.size()){
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
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
