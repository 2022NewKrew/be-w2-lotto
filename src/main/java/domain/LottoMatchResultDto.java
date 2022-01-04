package domain;

import domain.lottonumber.LottoNumber;

import java.util.List;

public class LottoMatchResultDto {

    private final int numberOfMatchedBasicNumber;
    private final boolean isMatchedBonusNumber;

    public LottoMatchResultDto(List<LottoNumber> matchedNumbers) {
        numberOfMatchedBasicNumber = (int) matchedNumbers.stream()
                .filter(lottoNumber -> !lottoNumber.isBonusNumber())
                .count();

        isMatchedBonusNumber = matchedNumbers.stream()
                .anyMatch(LottoNumber::isBonusNumber);
    }

    public int getNumberOfMatchedBasicNumber() {
        return numberOfMatchedBasicNumber;
    }

    public boolean isMatchedBonusNumber() {
        return isMatchedBonusNumber;
    }
}
