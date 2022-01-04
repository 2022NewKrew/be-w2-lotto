package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicateNumber(lottoNumbers);
        validateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야만 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumber(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER)
                .forEach(lottoNumber -> {
                    throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
                });
    }

    public int getLottoMatchCount(LottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
