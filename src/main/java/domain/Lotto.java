package domain;

import java.util.*;

public class Lotto {
    private static final int MATCHED = 1;
    private static final int MISMATCHED = 0;
    private static final int LOTTO_SIZE = 6;
    private static final String ILLEGAL_LOTTO = "로또는 6개의 서로 다른 숫자로 만들어져야 합니다";
    private Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateLottoSize();
    }

    public Lotto(String[] numbers) {
        for (String number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        validateLottoSize();
    }

    private void validateLottoSize() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO);
        }
    }

    public Rank match(WinningNumbers winningNumbers) {
        int hit = lottoNumbers.stream()
                .mapToInt(number -> winningNumbers.lottoNumbers().contains(number) ? MATCHED : MISMATCHED)
                .sum();
        boolean bonusNumber = lottoNumbers.contains(winningNumbers.bonusNumber());
        return Rank.from(hit, bonusNumber);
    }

    public List<LottoNumber> lottoNumbers() {
        return List.copyOf(lottoNumbers);
    }
}