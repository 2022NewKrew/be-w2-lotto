package domain.model.ticket;

import common.model.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket extends CommonLottoTicket{

    public LottoTicket(List<Integer> lottoNumbers) {
        super(lottoNumbers);
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
