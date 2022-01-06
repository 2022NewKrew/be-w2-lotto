package lotto.domain;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int SIZE_OF_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
        if (!isValidSizeOfLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("로또 넘버의 개수는 " + SIZE_OF_LOTTO_NUMBERS + " 개 여야 합니다.");
        }

        if (hasDuplicatedLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }

    private boolean isValidSizeOfLottoNumbers(List<LottoNumber> lottoNumbers) {
        return CollectionUtils.size(lottoNumbers) == SIZE_OF_LOTTO_NUMBERS;
    }

    private boolean hasDuplicatedLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().distinct().count() != SIZE_OF_LOTTO_NUMBERS;
    }

    public static LottoNumbers createByNumbers(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream().sorted().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream().anyMatch(lottoNumber::equals);
    }

    public int countMatchNumberOfLottoNumbers(LottoNumbers lottoNumbers) {
        return (int) this.lottoNumbers.stream().filter(lottoNumbers::contains).count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
