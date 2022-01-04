package lotto.view;

import lotto.domain.LottoController;
import lotto.dto.LottoPurchaseDto;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

public class Lotto {
    private final InputUtil inputUtil = new InputUtil();
    private final OutputUtil outputUtil  = new OutputUtil();
    private final LottoController lottoController = new LottoController();

    public void buy() {
        LottoPurchaseDto lotto = lottoController.buy(inputUtil.inputPrice());
        outputUtil.PrintPurchaseGameCnt(lotto.getPurchaseGameCnt());
        outputUtil.printPurchaseGames(lotto.getLottoGames());

        inputUtil.inputWinningNumber();
    };
}
