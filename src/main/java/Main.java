import service.OwnLotto;
import domain.Lotto;
import domain.Number;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int purchaseAmount = inputView.getPurchaseAmount();
        int manualLottoCount = inputView.getManualLottoCount();

        OwnLotto ownLotto = new OwnLotto(purchaseAmount, manualLottoCount);

        OutputView outputView = new OutputView();
        outputView.printPurchaseLottoList(ownLotto);

        ArrayList<Number> inputNumberList = inputView.getNumberList();
        Lotto winningLotto = new Lotto(inputNumberList);
        int bonusNumber = inputView.getBonusNumber();

//        WinningLottoManual winningLotto = new WinningLottoManual(winningNumber,bonusNumber);
//
//        ResultManager resultManager = new ResultManager(ownLotto, winningLotto);
//
//        outputView.printResult();
    }
}
