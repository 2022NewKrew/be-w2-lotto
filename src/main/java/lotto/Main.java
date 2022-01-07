package lotto;

import static spark.Spark.*;

import lotto.domain.*;
import lotto.io.*;

import java.util.*;

public class Main {
/*
    public static final InputManager<Scanner> im = new CLIInputManager();
    public static final OutputManager om = new CLIOutputManager();
    public static final PurchaseManager pm = new PurchaseManager();

    private static List<Lotto> lottoList;
    private static PurchaseInfo purchaseInfo;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int purchaseAmount = im.getPurchaseAmount(scanner);
            int totalNumOfPurchase = PurchaseInfo.getInitialNumOfPurchase(purchaseAmount);
            int manualLottoCount = im.getManualLottoCount(scanner, totalNumOfPurchase);
            List<Lotto> manualLottoList = im.getManualLotto(scanner, manualLottoCount);

            PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottoCount);
            List<Lotto> lottoList = pm.purchase(purchaseInfo, manualLottoList);
            System.out.println(om.printPurchaseInfo(purchaseInfo, lottoList));

            List<Integer> winningNumber = im.getWinningNumber(scanner);
            int bonusNumber = im.getBonusNumber(scanner, winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            System.out.println(om.printPrizes(purchaseInfo, winningInfo));
        }
    }
*/
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
            int manualLottoCount = manualNumberString.split(SPLIT_REGEX_LINE_BREAK).length;
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
