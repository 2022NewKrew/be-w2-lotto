package lotto.view;

import lotto.constant.Rank;
import lotto.domain.LottoController;
import lotto.dto.LottoPurchaseDto;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

import java.util.Map;

public class LottoShop {
    private final InputUtil inputUtil = new InputUtil();
    private final OutputUtil outputUtil  = new OutputUtil();
    private final LottoController lottoController = new LottoController();

    public void buy() {
        LottoPurchaseDto lotto = lottoController.autoBuy(inputUtil.inputPrice());
        outputUtil.PrintPurchaseGameCnt(lotto.getPurchaseGameCnt());
        outputUtil.printPurchaseGames(lotto.getLottoGames());

        Map<Rank, Integer> ranks = lottoController.checkRank(lotto, inputUtil.inputWinningNumber(), inputUtil.inputBonusNumber());
        Long totalWinningMoney = lottoController.getTotalWinningMoney(ranks);
        outputUtil.printRank(ranks);
        outputUtil.printBenefit(getBenefit(lotto, totalWinningMoney));

    };
    private double getBenefit(LottoPurchaseDto lotto, Long totalWinningMoney){
        return (double)(totalWinningMoney - lotto.getPurchaseAmount()) / lotto.getPurchaseAmount() * 100;
    }
}
