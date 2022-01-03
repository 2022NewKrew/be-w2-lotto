package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.LottoInfo.*;

public class LottoView {
    private static final String NEW_LINE = "\n";

    private final int purchaseMoney;
    private final int lottoNum;
    private final List<Lotto> lottoList;

    public LottoView(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        lottoNum = purchaseMoney / PRICE_OF_LOTTO.getValue();
        lottoList = new ArrayList<>(lottoNum);
        IntStream.range(0, lottoNum)
                .forEach(lotto -> lottoList.add(new Lotto()));
    }

    public String printPurchasedLotto() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoNum).append("개를 구매했습니다.").append(NEW_LINE);
        for (int i = 0; i < lottoNum; i++) {
            sb.append(lottoList.get(i).toString()).append(NEW_LINE);
        }
        return sb.toString();
    }

    public String printLottoResult(List<Integer> winningNumbers) {
        LottoResult lottoResult = new LottoResult(lottoList, winningNumbers);

        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append(NEW_LINE).append("---------").append(NEW_LINE);
        for (Rank rank : Rank.values()) {
            sb.append(LottoRankFormat(rank.getCountOfMatch(), rank.getWinningMoney(), lottoResult.getCountOfRank(rank))).append(NEW_LINE);
        }
        sb.append("총 수익률은 ").append(profitRate(lottoResult.getLottoProfit())).append("%입니다.");
        return sb.toString();
    }

    private String LottoRankFormat(int countOfMatch, int winningMoney, int countOfRank) {
        return String.format("%d개 일치 (%d원)- %d개", countOfMatch, winningMoney, countOfRank);
    }

    private long profitRate(int profit) {
        return profit * 100L / purchaseMoney;
    }
}