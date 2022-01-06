package lotto.domain;

import java.util.Arrays;

public enum PrizeType {
    FIRST_PRIZE(6, 2000000000) {
        @Override
        public void count(LottoResult lottoResult) {
            lottoResult.plusFirstPrizeCount();
        }
    },
    SECOND_PRIZE(5, 30000000) {
        @Override
        public void count(LottoResult lottoResult) {
            lottoResult.plusSecondPrizeCount();
        }
    },
    THIRD_PRIZE(5, 1500000) {
        @Override
        public void count(LottoResult lottoResult) {
            lottoResult.plusThirdPrizeCount();
        }
    },
    FOURTH_PRIZE(4, 50000) {
        @Override
        public void count(LottoResult lottoResult) {
            lottoResult.plusFourthPrizeCount();
        }
    },
    FIFTH_PRIZE(3, 5000) {
        @Override
        public void count(LottoResult lottoResult) {
            lottoResult.plusFifthPrizeCount();
        }
    };

    private final int value;
    private final int money;

    PrizeType(int value, int money) {
        this.value = value;
        this.money = money;
    }

    public abstract void count(LottoResult lottoResult);

    public static PrizeType valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND_PRIZE.value) {
            return isSecondOrThirdPrize(matchBonus);
        }
        return Arrays.stream(values())
                .filter(prizeType -> selectPrizeType(prizeType, matchCount) != null)
                .findAny()
                .orElse(null);
    }

    private static PrizeType selectPrizeType(PrizeType prizeType, int matchCount) {
        if (matchCount == prizeType.value) {
            return prizeType;
        }
        return null;
    }

    private static PrizeType isSecondOrThirdPrize(boolean matchBonus) {
        return matchBonus ? SECOND_PRIZE : THIRD_PRIZE;
    }

    public int getMoney() {
        return money;
    }
}
