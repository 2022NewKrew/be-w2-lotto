package com.upperleaf.web;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.lotto.LottoWinningNumber;
import com.upperleaf.web.dto.LottoStatisticsInfo;
import com.upperleaf.web.dto.LottosInfo;
import spark.ModelAndView;
import spark.Route;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

public class LottoRoutes {

    private static final TemplateEngine templateEngine = new HandlebarsTemplateEngine();
    private static final LottoService lottoService = LottoFactory.getInstance().lottoService();

    public static Route index() {
        return (request, response) -> templateEngine.render(new ModelAndView(Map.of(), "/index.html"));
    }

    public static Route buyLotto() {
        return ((request, response) -> {
            long inputMoney = Long.parseLong(request.queryParams("inputMoney"));
            String manualNumber = request.queryParams("manualNumber");

            LottosInfo info = lottoService.buyLotto(new LottoPaymentInfo(inputMoney, manualNumber));
            response.cookie("lottoId", String.valueOf(info.getLottoId()));
            return templateEngine.render(new ModelAndView(info, "/show.html"));
        });
    }

    public static Route matchLotto() {
        return ((request, response) -> {
            String lottoId = request.cookie("lottoId");
            String winNumber = request.queryParams("winningNumber");
            int bonusNumber = Integer.parseInt(request.queryParams("bonusNumber"));
            LottoWinningNumber winningNumber = new LottoWinningNumber(winNumber, bonusNumber);

            LottoStatisticsInfo statisticsInfo = lottoService.matchLotto(winningNumber, Long.parseLong(lottoId));
            return templateEngine.render(new ModelAndView(statisticsInfo, "/result.html"));
        });
    }

}
