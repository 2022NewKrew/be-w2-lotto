package lotto;

import static spark.Spark.*;

import lotto.domain.*;
import lotto.io.*;

import java.util.*;

public class Main {
    public static final InputManager<String> im = new WebInputManager();
    private static final OutputManager om = new WebOutputManager();

    private static final String PATH_STATIC = "/static";
    private static final String PATH_BUY_LOTTO = "/buyLotto";
    private static final String PATH_MATCH_LOTTO = "/matchLotto";

    private static final String SPLIT_REGEX_LINE_BREAK = "\r?\n";

    private static final String QUERY_PARAMS_INPUT_MONEY = "inputMoney";
    private static final String QUERY_PARAMS_MANUAL_NUMBER = "manualNumber";
    private static final String QUERY_PARAMS_WINNING_NUMBER = "winningNumber";
    private static final String QUERY_PARAMS_BONUS_NUMBER = "bonusNumber";

    private static List<Lotto> lottoList;
    private static PurchaseInfo purchaseInfo;

    public static void main(String[] args) {
        staticFiles.location(PATH_STATIC);
        port(8080);

        post(PATH_BUY_LOTTO, (req, res) -> {
            int purchaseAmount = im.getPurchaseAmount(req.queryParams(QUERY_PARAMS_INPUT_MONEY));
            String manualNumberString = req.queryParams(QUERY_PARAMS_MANUAL_NUMBER);
            int manualLottoCount =
                    im.getManualLottoCount(
                            Integer.toString(manualNumberString.split(SPLIT_REGEX_LINE_BREAK).length),
                            PurchaseInfo.getInitialNumOfPurchase(purchaseAmount)
                    );
            List<Lotto> manualLottos = im.getManualLotto(manualNumberString, manualLottoCount);

            purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottos.size());
            PurchaseManager purchaseManager = new PurchaseManager();
            lottoList = purchaseManager.purchase(purchaseInfo, manualLottos);

            return om.printPurchaseInfo(purchaseInfo, lottoList);
        });

        post(PATH_MATCH_LOTTO, (req, res) -> {
            List<Integer> winningNumber = im.getWinningNumber(req.queryParams(QUERY_PARAMS_WINNING_NUMBER));
            int bonusNumber = im.getBonusNumber(req.queryParams(QUERY_PARAMS_BONUS_NUMBER), winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            return om.printPrizes(purchaseInfo, winningInfo);
        });
    }
}
