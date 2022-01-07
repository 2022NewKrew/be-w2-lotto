package lotto;

import static spark.Spark.*;

import lotto.domain.*;
import lotto.io.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

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
            System.out.println(om.printPurchaseInfo(purchaseInfo));
            List<Lotto> lottoList = pm.purchase(purchaseInfo, manualLottoList);
            System.out.println(om.printAllLotto(lottoList));

            List<Integer> winningNumber = im.getWinningNumber(scanner);
            int bonusNumber = im.getBonusNumber(scanner, winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            System.out.println(om.printPrizes(purchaseInfo, winningInfo));
        }
    }
*/
    public static final InputManager<String> im = new WebInputManager();
    private static final OutputManager om = new WebOutputManager();

    private static List<Lotto> lottoList;
    private static PurchaseInfo purchaseInfo;

    public static void main(String[] args) {
        staticFiles.location("/static");
        port(8080);

        post("/buyLotto", (req,res) -> {
            int purchaseAmount = im.getPurchaseAmount(req.queryParams("inputMoney"));
            int manualLottoCount = req.queryParams("manualNumber").split("\r?\n").length;
            List<Lotto> manualLottos = im.getManualLotto(req.queryParams("manualNumber"), manualLottoCount);

            purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottos.size());
            PurchaseManager purchaseManager = new PurchaseManager();
            lottoList = purchaseManager.purchase(purchaseInfo, manualLottos);

            return om.printPurchaseInfo(purchaseInfo, lottoList);
        });

        post("/matchLotto", (req,res) -> {
            List<Integer> winningNumber = im.getWinningNumber(req.queryParams("winningNumber"));
            int bonusNumber = im.getBonusNumber(req.queryParams("bonusNumber"), winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            return om.printPrizes(purchaseInfo, winningInfo);
        });
    }
}
