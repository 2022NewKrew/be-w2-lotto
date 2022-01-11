package lotto.view;


import lotto.VO.Rank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWebView implements LottoView {

    @Override
    public String printLottos(Lottos lottos) {
        Map<String, Object> data = new HashMap<>();
        data.put("lottosSize", lottos.size());
        data.put("lottos", lottos);

        return render(data, "show.html");
    }

    @Override
    public String printLottoResult(LottoResult lottoResult, float totalRateOfReturn) {
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> dataLottoResult = new HashMap<>();

        dataLottoResult.put("message", renderLottoResultMessage(lottoResult));
        dataLottoResult.put("totalRateOfReturn", totalRateOfReturn);
        data.put("lottosResult", dataLottoResult);

        return render(data, "result.html");
    }

    @Override
    public String printError(String message) {
        //TO DO 에러페이지 html
        return message;
    }

    public List<String> renderLottoResultMessage(LottoResult lottoResult) {
        List<String> message = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            StringBuilder builder = new StringBuilder();
            builder.append(rank.toString());
            builder.append(" - ");
            builder.append(lottoResult.getCountOf(rank));
            builder.append("개");
            message.add(builder.toString());
        }

        return message;
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }


}
