package lotto.io;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebOutputManager implements OutputManager{
    private static final String PATH_SHOW_HTML = "show.html";
    private static final String PATH_RESULT_HTML = "result.html";

    private static final String QUERY_PARAMS_LOTTO_SIZE = "lottoSize";
    private static final String QUERY_PARAMS_LOTTOS = "lottos";
    private static final String QUERY_PARAMS_LOTTO_RESULT = "lottosResult";
    private static final String QUERY_PARAMS_MESSAGE = "message";
    private static final String QUERY_PARAMS_TOTAL_RATE_OF_RETURN = "totalRateOfReturn";

    private static final String MATCH_COUNT_FORMAT = "%d개 일치(%d원)- %d개%n";
    private static final String MATCH_COUNT_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개%n";

    private static final HandlebarsTemplateEngine handlebarsTemplateEngine = new HandlebarsTemplateEngine();

    @Override
    public String printPurchaseInfo(PurchaseInfo purchaseInfo, List<Lotto> lottoList) {
        Map<String, Object> model = new HashMap<>();
        model.put(QUERY_PARAMS_LOTTO_SIZE, purchaseInfo.getNumOfPurchase());
        model.put(QUERY_PARAMS_LOTTOS, lottoList);

        return render(model, PATH_SHOW_HTML);
    }

    @Override
    public String printPrizes(PurchaseInfo purchaseInfo, WinningInfo winningInfo) {
        double returnRate = (double) (winningInfo.getReturnAmount() - purchaseInfo.getPurchaseAmount()) * 100 / purchaseInfo.getPurchaseAmount();
        Map<String, Object> model = new HashMap<>();
        LottoResult lottoResult = new LottoResult(buildMessage(winningInfo), returnRate);
        model.put(QUERY_PARAMS_LOTTO_RESULT, lottoResult);
        model.put(QUERY_PARAMS_MESSAGE, lottoResult.getMessage());
        model.put(QUERY_PARAMS_TOTAL_RATE_OF_RETURN, lottoResult.getTotalRateOfReturn());
        return render(model, PATH_RESULT_HTML);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return handlebarsTemplateEngine.render(new ModelAndView(model, templatePath));
    }

    private List<String> buildMessage(WinningInfo winningInfo) {
        return Arrays.stream(Rank.values()).filter(Rank::isWin).map(rank -> {
            String format = setFormat(rank);
            return String.format(format, rank.getMatchCount(), rank.getWinningMoney(), winningInfo.getWinCount().get(rank));
        }).collect(Collectors.toList());
    }

    private String setFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return MATCH_COUNT_BONUS_FORMAT;
        }
        return MATCH_COUNT_FORMAT;
    }
}
