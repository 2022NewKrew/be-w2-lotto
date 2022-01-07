package domain.lotto;

import java.util.List;

import static util.LottoConst.*;
import static util.LottoConst.MAX_LOTTO_NUMBER;

public class LottoOrder {

    private final List<Integer> lottoNumbers;

    public LottoOrder(List<Integer> lottoNumbers) {
        validateLottoBoundaries(lottoNumbers);
        validateLottoNumberSize(lottoNumbers);
        validateDuplicateNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoBoundaries(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoBoundary(number);
        }
    }

    private void validateLottoBoundary(int number) {
        if (!LOTTO_NUMBERS.contains(number)) {
            throw new IllegalArgumentException(
                    String.format("[에러] 로또 번호는 %s ~ %s 사이의 숫자를 입력해야 합니다.",
                            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            );
        }
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(
                    String.format("[에러] 로또 번호는 반드시 %s개를 입력해야 합니다.", MAX_LOTTO_COUNT)
            );
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[에러] 로또 번호는 중복되는 숫자가 없어야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
