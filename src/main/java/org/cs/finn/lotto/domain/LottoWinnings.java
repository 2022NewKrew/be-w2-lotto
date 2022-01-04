package org.cs.finn.lotto.domain;

import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoWinnings {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinnings(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        this.lottoNumbers = Objects.requireNonNull(lottoNumbers);
        this.bonusNumber = Objects.requireNonNull(bonusNumber);

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("BonusNumber is found in winningNumbers!");
        }
    }

    public List<LottoNumber> getWinningsList() {
        return Collections.unmodifiableList(lottoNumbers.getList());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "당첨 번호: " + lottoNumbers + ", 보너스 번호: " + bonusNumber;
    }
}
