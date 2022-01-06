package bin.jaden.be_w2_lotto.renderer;

import bin.jaden.be_w2_lotto.data.LottoGameResult;
import bin.jaden.be_w2_lotto.lottoGame.LottoGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRenderer {

    public String getIndexRender() {
        return render(null, "/index.html");
    }

    public String getBuyLottoRender(List<LottoGame> lottoGames) {
        Map<Object, Object> model = new HashMap<>();
        model.put("lottos", lottoGames);
        model.put("lottosSize", lottoGames.size());
        return render(model, "/show.html");
    }

    public String getBuyLottoErrorRender(String message, List<LottoGame> lottoGames) {
        Map<Object, Object> model = new HashMap<>();
        model.put("lottos", lottoGames);
        model.put("lottosSize", lottoGames.size());
        model.put("message", message);
        return render(model, "/show.html");
    }

    public String getMatchLottoRender(List<LottoGameResult> results) {
        Map<Object, Object> model = new HashMap<>();
        model.put("lottosResult", results);
        return render(model, "/result.html");
    }


    public String getErrorRender(String message, String templatePath) {
        Map<Object, Object> model = new HashMap<>();
        model.put("message", message);
        return render(model, templatePath);
    }

    private String render(Map<Object, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
