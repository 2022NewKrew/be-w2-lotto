package dto;

import java.util.List;

public class LottoCreateDto {
    private final List<Integer> lottoSequence;
    private final boolean autoCreated;

    public LottoCreateDto(List<Integer> lottoSequence,
                          boolean autoCreated) {
        this.lottoSequence = lottoSequence;
        this.autoCreated = autoCreated;
    }

    public List<Integer> getLottoSequence() {
        return lottoSequence;
    }

    public boolean getAutoCreated() {
        return autoCreated;
    }
}
