package view;

import lotto.*;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class PrintLotto {

    private static int money = 0;
    private static LottoMachine lottoMachine = new LottoMachine();

    public static void runServer() {
        port(8080);
        staticFiles.location("/");
        post("buyLotto", PrintLotto::postBuyLotto);
        post("matchLotto", PrintLotto::postMatchLotto);
    }

    private static String postBuyLotto(spark.Request request, spark.Response response) {
        try {
            money = Integer.parseInt(request.queryParams("inputMoney"));
            final List<String> manualNumbers = Arrays.asList(request.queryParams("manualNumber").split("\r?\n"));
            List<UserLotto> manualLottos = manualNumbers.stream().map(x -> new UserLotto(splitNumbers(x))).collect(Collectors.toList());

            lottoMachine = new LottoMachine();
            lottoMachine.addManualLottos(manualLottos);
            lottoMachine.buyLotto(money - manualLottos.size() * 1000);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosSize", lottoMachine.getAllLottos().size());
            model.put("lottos", lottoMachine.getAllLottos().stream().map(x -> Collections.singletonMap("numbers", x.toString())).collect(Collectors.toList()));

            return render(model, "/show.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String postMatchLotto(spark.Request request, spark.Response response) {
        WinningLotto winningLotto = new WinningLotto(splitNumbers(request.queryParams("winningNumber")), LottoBall.values()[Integer.parseInt(request.queryParams("bonusNumber"))-1]);
        RankCount rankCount = lottoMachine.getRankCount(winningLotto);

        Map<String, List<String>> message = Collections.singletonMap("message",
                Arrays.asList(
                        "3개 일치 (5000원)- " + rankCount.getFifthCount() + "개",
                        "4개 일치 (50000원)- " + rankCount.getFourthCount() + "개",
                        "5개 일치 (1500000원)- " + rankCount.getThirdCount() + "개",
                        "5개 일치, 보너스 볼 일치(30000000원)- " + rankCount.getSecondCount() + "개",
                        "6개 일치 (2000000000원)- " + rankCount.getFirstCount() + "개"
                )
        );
        Map<String, Object> model = new HashMap<>();
        model.put("lottosResult", message);
        model.put("totalRateOfReturn", (calcProfit(rankCount) - money)  * 100 / money);

        return render(model, "/result.html");
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static List<LottoBall> splitNumbers(String numStr) {
        final List<String> inputs = new ArrayList<>(Arrays.asList(numStr.split(",")));
        return inputs.stream().map(x -> LottoBall.values()[Integer.parseInt(x.trim())-1]).collect(Collectors.toList());
    }

    private static long calcProfit(RankCount rankCount) {
        return rankCount.getFifthCount() * Rank.FIFTH.getWinningMoney()
                + rankCount.getFourthCount() * Rank.FOURTH.getWinningMoney()
                + rankCount.getThirdCount() * Rank.THIRD.getWinningMoney()
                + rankCount.getSecondCount() * Rank.SECOND.getWinningMoney()
                + rankCount.getFirstCount() * Rank.FIRST.getWinningMoney();
    }
}
