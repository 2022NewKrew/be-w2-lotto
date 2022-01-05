package domain;

import dto.LottoMatchResultDto;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    FIRST(2_000_000_000, 6,false), SECOND(30_000_000,5,true),
    THIRD(1_500_000, 5, false), FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false);

    private final long prizeMoney;
    private final int numberOfMatchedNumber;
    private final boolean isNeedMatchedBonusNumber;

    LottoResult(long prizeMoney, int numberOfMatchedNumber, boolean isNeedMatchedBonusNumber) {
        this.prizeMoney = prizeMoney;
        this.numberOfMatchedNumber = numberOfMatchedNumber;
        this.isNeedMatchedBonusNumber = isNeedMatchedBonusNumber;
    }

    public static Optional<LottoResult> getLottoResultType(LottoMatchResultDto lottoMatchResultDto) {
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.getNumberOfMatchedNumber() == lottoMatchResultDto.getNumberOfMatchedBasicNumber())
                .filter(lottoResult -> {
                    // 보너스 번호가 필요한거라면 보너스 번호가 매치가 되어야한다. (적절한 메소드명을 못 정하겠다.)
                    if(lottoResult.isNeedMatchedBonusNumber()) {
                        return lottoMatchResultDto.isMatchedBonusNumber();
                    }

                    return true;
                })
                .findAny();
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfMatchedNumber() {
        return numberOfMatchedNumber;
    }

    public boolean isNeedMatchedBonusNumber() {
        return isNeedMatchedBonusNumber;
    }
}
