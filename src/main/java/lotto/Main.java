package lotto;

import static spark.Spark.*;

import lotto.domain.*;
import lotto.io.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String CLI_PURCHASE_AMOUNT_TITLE = "구입금액을 입력해 주세요.";
    private static final String CLI_MANUAL_LOTTO_COUNT_TITLE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String CLI_MANUAL_LOTTO_TITLE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String CLI_WINNING_NUMBER_TITLE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String CLI_BONUS_NUMBER_TITLE = "보너스 볼을 입력해 주세요.";

    public static final InputManager im = new CLIInputManager();
    public static final OutputManager om = new CLIOutputManager();
    public static final PurchaseManager pm = new PurchaseManager();

    private static List<Lotto> lottoList;
    private static PurchaseInfo purchaseInfo;

    /*
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int purchaseAmount = getPurchaseAmountAndCheck(scanner);
            int totalNumOfPurchase = PurchaseInfo.getInitialNumOfPurchase(purchaseAmount);
            int manualLottoCount = getManualLottoCountAndCheck(scanner, totalNumOfPurchase);
            List<Lotto> manualLottoList = getManualLottoAndCheck(scanner, manualLottoCount);

            PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottoCount);
            List<Lotto> lottoList = pm.purchase(purchaseInfo, manualLottoList);
            om.printAllLotto(lottoList);

            List<Integer> winningNumber = getWinningNumberAndCheck(scanner);
            int bonusNumber = getBonusNumberAndCheck(scanner, winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            om.printPrizes(purchaseInfo, winningInfo);
        }
    }
    */

    public static void main(String[] args) {
        staticFiles.location("/static");
        port(8080);

        post("/buyLotto", (req,res) -> {
            int purchaseAmount = Integer.parseInt(req.queryParams("inputMoney"));
            List<Lotto> manualLottos = Arrays.stream(
                    req.queryParams("manualNumber")
                            .split("\r?\n")
                    ).map(number -> Arrays.stream(
                            number.replace(" ", "")
                                    .split(",")
                            )
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
                    ).map(LottoGenerator::generateManualLotto)
                    .collect(Collectors.toList());
            purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottos.size());
            PurchaseManager purchaseManager = new PurchaseManager();
            lottoList = purchaseManager.purchase(purchaseInfo, manualLottos);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosSize", purchaseInfo.getNumOfPurchase());
            model.put("lottos", lottoList);

            return render(model, "show.html");
        });

        post("/matchLotto", (req,res) -> {
            List<Integer> winningNumber = Arrays.stream(
                    req.queryParams("winningNumber")
                            .replace(" ", "")
                            .split(",")
                    ).map(Integer::parseInt)
                    .collect(Collectors.toList());
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            double returnRate = (double) (winningInfo.getReturnAmount() - purchaseInfo.getPurchaseAmount()) * 100 / purchaseInfo.getPurchaseAmount();
            Map<String, Object> model = new HashMap<>();
            model.put("lottosResult", new LottoResult(winningInfo.buildMessage(), returnRate));
            model.put("message", winningInfo.buildMessage());
            model.put("totalRateOfReturn", returnRate);
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
/*
    private static int getPurchaseAmountAndCheck(Scanner scanner) {
        System.out.println(CLI_PURCHASE_AMOUNT_TITLE);
        int purchaseAmount = im.getPurchaseAmount(scanner.nextLine());
        ExceptionCheck.checkValidPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static int getManualLottoCountAndCheck(Scanner scanner, int totalNumOfPurchase) {
        System.out.println(CLI_MANUAL_LOTTO_COUNT_TITLE);
        int manualLottoCount = im.getManualLottoCount(scanner.nextLine());
        ExceptionCheck.checkValidManualLottoCount(manualLottoCount, totalNumOfPurchase);
        return manualLottoCount;
    }

    private static List<Lotto> getManualLottoAndCheck(Scanner scanner, int manualLottoCount) {
        System.out.println(CLI_MANUAL_LOTTO_TITLE);
        if (manualLottoCount == 0) {
            return Collections.unmodifiableList(new ArrayList<>());
        }
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoList.add(im.getManualLotto(scanner.nextLine()));
        }
        ExceptionCheck.checkValidManualLotto(manualLottoList, manualLottoCount);
        return Collections.unmodifiableList(manualLottoList);
    }

    private static List<Integer> getWinningNumberAndCheck(Scanner scanner) {
        System.out.println(CLI_WINNING_NUMBER_TITLE);
        List<Integer> winningNumber = im.getWinningNumber(scanner.nextLine());
        ExceptionCheck.checkValidNumberList(winningNumber);
        return winningNumber;
    }

    private static int getBonusNumberAndCheck(Scanner scanner, List<Integer> winningNumber) {
        System.out.println(CLI_BONUS_NUMBER_TITLE);
        int bonusNumber = im.getBonusNumber(scanner.nextLine());
        ExceptionCheck.checkValidBonusNumber(bonusNumber);
        ExceptionCheck.checkBonusNumberInWinningNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }
*/
}
