package domain;

import common.model.LottoRank;
import domain.model.WinningLottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static LottoTicket createAutoLottoTicket() {
        List<Integer> baseNumberList = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(baseNumberList);
        List<Integer> lottoNumberList = new ArrayList<>(baseNumberList.subList(0, 6));
        Collections.sort(lottoNumberList);
        return LottoTicket.from(lottoNumberList);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
