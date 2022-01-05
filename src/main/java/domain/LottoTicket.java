package domain;

import common.model.LottoRank;
import domain.model.WinningLottoTicket;

import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    public LottoRank checkRank(WinningLottoTicket winningTicket) {
        int winningCount = (int)(lottoNumbers.stream()
                .filter(number -> winningTicket.contains(number))
                .count());
        boolean matchBonus = lottoNumbers.stream().anyMatch(number -> winningTicket.matchBonus(number));
        return LottoRank.findLottoRankByWinningCountAndMatchBonus(winningCount, matchBonus);
    }

    public static LottoTicket from(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
