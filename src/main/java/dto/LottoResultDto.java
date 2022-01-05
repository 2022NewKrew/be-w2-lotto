package dto;

import domain.LottoResult;

public class LottoResultDto implements Comparable<LottoResultDto> {

    private final LottoResult lottoResult;
    private final int count;

    public LottoResultDto(LottoResult lottoResult, int count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(LottoResultDto o) {
        return lottoResult.getPrizeMoney() > o.getLottoResult().getPrizeMoney() ? 1 :
                (lottoResult.getPrizeMoney() == o.getLottoResult().getPrizeMoney() ? 0 : -1);
    }
}
