package dto;

import domain.Lotto;

import java.util.List;

public class LottoDto {
    private List<Integer>  lottoSequence;
    private boolean autoCreated;

    public LottoDto() {}

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

    public void setLottoSequence(List<Integer> lottoSequence) {
        this.lottoSequence = lottoSequence;
    }

    public void setAutoCreated(boolean autoCreated) {
        this.autoCreated = autoCreated;
    }
}
