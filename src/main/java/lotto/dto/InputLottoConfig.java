package lotto.dto;

import lotto.collections.LottoLine;

import java.util.List;

public class InputLottoConfig {
    private int manualLottoCnt = 0;
    private int totalLottoCnt = 0;
    private List<LottoLine> lottoLines;

    public InputLottoConfig(int manualLottoCnt, int totalLottoCnt, List<LottoLine> lottoLines){
        this.manualLottoCnt = manualLottoCnt;
        this.totalLottoCnt = totalLottoCnt;
        this.lottoLines = lottoLines;
    }

    public int getTotalLottoCnt() {
        return totalLottoCnt;
    }

    public int getManualLottoCnt() {
        return manualLottoCnt;
    }

    public List<LottoLine> getLottoLines() {
        return lottoLines;
    }
}
