package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningInfo;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebOutputManager implements OutputManager{
    private static final String PATH_SHOW_HTML = "show.html";
    private static final String PATH_RESULT_HTML = "result.html";
    private static final String QUERY_PARAMS_LOTTO_SIZE = "lottoSize";
    private static final String QUERY_PARAMS_LOTTOS = "lottos";
    private static final String QUERY_PARAMS_LOTTO_RESULT = "lottosResult";
    private static final String QUERY_PARAMS_MESSAGE = "message";
    private static final String QUERY_PARAMS_TOTAL_RATE_OF_RETURN = "totalRateOfReturn";


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
        LottoResult lottoResult = new LottoResult(winningInfo.buildMessage(), returnRate);
        model.put(QUERY_PARAMS_LOTTO_RESULT, lottoResult);
        model.put(QUERY_PARAMS_MESSAGE, lottoResult.getMessage());
        model.put(QUERY_PARAMS_TOTAL_RATE_OF_RETURN, lottoResult.getTotalRateOfReturn());
        return render(model, PATH_RESULT_HTML);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
