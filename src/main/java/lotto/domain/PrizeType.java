package lotto.domain;

import lotto.dto.LottoResultDTO;

public enum PrizeType {
    FIRST_PRIZE(6, 2000000000) {
        @Override
        public void count(LottoResultDTO lottoResultDTO) {
            lottoResultDTO.plusFirstPrizeCount();
        }
    },
    SECOND_PRIZE(5, 30000000) {
        @Override
        public void count(LottoResultDTO lottoResultDTO) {
            lottoResultDTO.plusSecondPrizeCount();
        }
    },
    THIRD_PRIZE(5, 1500000) {
        @Override
        public void count(LottoResultDTO lottoResultDTO) {
            lottoResultDTO.plusThirdPrizeCount();
        }
    },
    FOURTH_PRIZE(4, 50000) {
        @Override
        public void count(LottoResultDTO lottoResultDTO) {
            lottoResultDTO.plusFourthPrizeCount();
        }
    },
    FIFTH_PRIZE(3, 5000) {
        @Override
        public void count(LottoResultDTO lottoResultDTO) {
            lottoResultDTO.plusFifthPrizeCount();
        }
    };

    private final int value;
    private final int money;

    PrizeType(int value, int money) {
        this.value = value;
        this.money = money;
    }

    public abstract void count(LottoResultDTO lottoResultDTO);

    public static PrizeType valueOf(int matchCount, boolean matchBonus) {
        PrizeType prizeType = null;
        for (PrizeType prize : values()) {
            prizeType = selectPrizeType(prize, matchCount, matchBonus);
        }
        return prizeType;
    }

    private static PrizeType selectPrizeType(PrizeType prizeType, int matchCount, boolean matchBonus) {
        if (matchCount == SECOND_PRIZE.value) {
            return matchBonus ? SECOND_PRIZE : THIRD_PRIZE;
        } else if (matchCount == prizeType.value) {
            return prizeType;
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public int getMoney() {
        return money;
    }
}
