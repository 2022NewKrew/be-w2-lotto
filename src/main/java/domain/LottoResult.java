package domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    FIRST(2_000_000_000, 6), THIRD(1_500_000, 5),
    FOURTH(50_000, 4), FIFTH(5_000, 3);

    private final long prizeMoney;
    private final int numberOfMatchedNumber;

    LottoResult(long prizeMoney, int numberOfMatchedNumber) {
        this.prizeMoney = prizeMoney;
        this.numberOfMatchedNumber = numberOfMatchedNumber;
    }

    public static Optional<LottoResult> getLottoResultType(int numberOfMatchedNumber) {
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.getNumberOfMatchedNumber() == numberOfMatchedNumber)
                .findAny();
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfMatchedNumber() {
        return numberOfMatchedNumber;
    }
}
