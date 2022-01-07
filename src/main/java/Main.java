import VO.PurchaseVO;
import VO.WinningLottoVO;
import controller.InputController;
import controller.OutputController;
import controller.PurchaseController;
import controller.StatsController;
import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static InputController inputController = new InputController();
    private final static OutputController outputController = new OutputController();
    private final static PurchaseController purchaseController = new PurchaseController();
    private final static StatsController statsController = new StatsController();

    //private final static LottoController lottoController = new LottoController();

    private static PurchaseVO purchaseVO;
    private static List<Lotto> lottoList = new ArrayList<>();
    private static WinningLottoVO winningLottoVO;

    public static void main(String[] args) {
        getPurchaseInput();
        purchaseLotto();
        printPurchasedLotto();
        getWinningLottoInput();
        //lottoController.runLotto();
    }

    private static void getPurchaseInput() {
        purchaseVO = inputController.getPurchaseVO();
    }

    private static void purchaseLotto() {
        List<Lotto> manualLottoList = purchaseController.purchaseManualLotto(purchaseVO.getManualLottoStringList());
        List<Lotto> randomLottoList = purchaseController.purchaseRandomLotto(purchaseVO.getMoney(), purchaseVO.getManualAmount());
        lottoList.addAll(manualLottoList);
        lottoList.addAll(randomLottoList);
    }

    private static void printPurchasedLotto() {
        outputController.printPurchasedLottoList(lottoList, purchaseVO.getMoney(), purchaseVO.getManualAmount());
    }

    private static void getWinningLottoInput() {
        winningLottoVO = inputController.getWinningLottoVO();
        System.out.println(winningLottoVO.getBonusNumber());
    }
}
