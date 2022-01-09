package dto;

import model.lotto.LottoRank;

import java.util.Map;

public class LottoResultEntryDto {
    private final int matchNumber;
    private final int reward;
    private final boolean needBonusNumber;
    private final int value;

    public LottoResultEntryDto(Map.Entry<LottoRank, Integer> entry) {
        this.matchNumber = entry.getKey().getMatchNumber();
        this.reward = entry.getKey().getReward();
        this.needBonusNumber = entry.getKey().getNeedBonusNumber();
        this.value = entry.getValue();
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getReward() {
        return reward;
    }

    public boolean isNeedBonusNumber() {
        return needBonusNumber;
    }

    public int getValue() {
        return value;
    }
}
