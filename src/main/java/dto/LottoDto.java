package dto;

import back.domain.Lotto;

import java.util.List;

public class LottoDto {
    private final List<Integer>  lottoSequence;
    private final boolean autoCreated;

    public LottoDto(List<Integer> lottoSequence, boolean autoCreated) {
        this.lottoSequence = lottoSequence;
        this.autoCreated = autoCreated;
    }

    public static LottoDto of(Lotto lotto) {
        return new LottoDto(lotto.getLottoSequence(), lotto.getAutoCreated());
    }

    public List<Integer> getLottoSequence() {
        return lottoSequence;
    }

    public boolean getAutoCreated() {
        return autoCreated;
    }
}
