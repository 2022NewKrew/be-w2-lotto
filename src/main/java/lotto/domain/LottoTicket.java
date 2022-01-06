package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicateNumber(lottoNumbers);
        validateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야만 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumber(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber < Constants.MIN_LOTTO_NUMBER || lottoNumber > Constants.MAX_LOTTO_NUMBER)
                .findAny()
                .ifPresent(lottoNumber -> {
                    throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
                });
    }

    public int getLottoMatchCount(LottoTicket winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::hasNumber).count();
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
