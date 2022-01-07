package view.dto;

import domain.LottoResult;

public class LottoResultDto implements Comparable<LottoResultDto> {

    private final LottoResult lottoResult;
    private final long count;

    public LottoResultDto(LottoResult lottoResult, long count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public long getCount() {
        return count;
    }

    @Override
    public int compareTo(LottoResultDto o) {
        return Long.compare(lottoResult.getPrizeMoney(), o.getLottoResult().getPrizeMoney());
    }
}
