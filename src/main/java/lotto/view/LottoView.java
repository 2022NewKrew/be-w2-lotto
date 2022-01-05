package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.generator.ManualLotto;
import lotto.domain.userinput.PurchasedLottoInput;
import lotto.domain.userinput.WinningLottoInput;
import lotto.domain.generator.AutoLotto;
import lotto.domain.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoInfo.*;

public class LottoView {
    private static final String NEW_LINE = "\n";

    private final int purchaseMoney;
    private final int countOfManualLotto;
    private final int countOfAutoLotto;
    private final List<Lotto> lottoList;

    public LottoView(PurchasedLottoInput purchasedLottoInput) {
        purchaseMoney = purchasedLottoInput.getPurchasePrice();
        countOfManualLotto = purchasedLottoInput.getCountOfManualLotto();
        countOfAutoLotto = (purchaseMoney / PRICE_OF_LOTTO.getValue()) - countOfManualLotto;
        lottoList = new ArrayList<>();
        generateManualLotto(purchasedLottoInput.getManualLottoBundle());
        generateAutoNumbers();
    }

    private void generateManualLotto(List<Lotto> manualLottoBundle) {
        LottoGenerator lottoGenerator = new ManualLotto(manualLottoBundle);
        lottoList.addAll(lottoGenerator.generateTickets());
    }

    private void generateAutoNumbers() {
        LottoGenerator lottoGenerator = new AutoLotto(countOfAutoLotto);
        lottoList.addAll(lottoGenerator.generateTickets());
    }

    public String printPurchasedLotto() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", countOfManualLotto, countOfAutoLotto)).append(NEW_LINE);
        for (int i = 0; i < countOfManualLotto + countOfAutoLotto; i++) {
            sb.append(lottoList.get(i).toString()).append(NEW_LINE);
        }
        return sb.toString();
    }

    public String printLottoResult(WinningLottoInput winningLottoInput) {
        LottoResult lottoResult = new LottoResult(lottoList, winningLottoInput);

        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append(NEW_LINE).append("---------").append(NEW_LINE);
        for (Rank rank : Rank.values()) {
            sb.append(LottoRankFormat(rank, lottoResult.getCountOfRank(rank))).append(NEW_LINE);
        }
        sb.append("총 수익률은 ").append(profitRate(lottoResult.getLottoProfit())).append("%입니다.");
        return sb.toString();
    }

    private String LottoRankFormat(Rank rank, int countOfRank) {
        String bonusString = "";
        if (rank == Rank.SECOND) {
            bonusString = ", 보너스 볼 일치";
        }
        return String.format("%d개 일치%s (%d원)- %d개", rank.getCountOfMatch(), bonusString, rank.getWinningMoney(), countOfRank);
    }

    private long profitRate(int profit) {
        return (profit - purchaseMoney) * 100L / purchaseMoney;
    }
}