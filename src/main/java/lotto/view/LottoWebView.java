package lotto.view;

import lotto.VO.InvalidFormatException;
import lotto.VO.Rank;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.model.Lotto;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;
import static spark.Spark.staticFiles;

import lotto.model.WinningLotto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class LottoWebView extends LottoView {

    public LottoWebView() {
        super();
    }

    public void start() {
        port(8080);
        staticFiles.location("/templates");

        post("/buyLotto", (req, res) -> {
            try {
                return render(buyLotto(req), "show.html");
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        });

        post("/matchLotto", (req, res) -> {
            try {
                return render(matchLotto(req), "result.html");
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        });
    }

    public Map<String, Object> buyLotto(spark.Request req) {

        Money money = parseMoney(req.queryParams("inputMoney"));
        List<Lotto> customLottos = parseCustomLottos(req.queryParams("manualNumber"));
        app.purchaseCustomLottos(money, customLottos);
        app.purchaseLotto(money);

        Map<String, Object> data = new HashMap<>();
        data.put("lottosSize", app.getLottos().size());
        data.put("lottos", renderLottos());

        return data;
    }

    public List<Lotto> renderLottos(){
        List<Lotto> lottos = new ArrayList<>();
        for(Lotto lotto : app.getLottos()){
            lottos.add(lotto);
        }
        return lottos;
    }

    public Map<String, Object> matchLotto(spark.Request req) {

        WinningLotto winningLotto = new WinningLotto(
                parseLotto(req.queryParams("winningNumber")),
                parseBonusNumber(req.queryParams("bonusNumber"))
        );
        app.setWinLotto(winningLotto);
        app.match();
        LottoResult lottoResult = app.getLottoResult();

        Map<String, Object> data = new HashMap<>();
        Map<String, Object> dataLottoResult = new HashMap<>();

        dataLottoResult.put("message", renderLottoResultMessage(lottoResult));
        dataLottoResult.put("totalRateOfReturn", app.calculateRateOfReturn());
        data.put("lottosResult", dataLottoResult);

        return data;
    }

    public List<String> renderLottoResultMessage(LottoResult lottoResult){
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

    public Money parseMoney(String inputString) throws InvalidFormatException {
        int inputNumber = Integer.parseInt(inputString);
        return new Money(validatedMoneyNumber(inputNumber));
    }

    public int parseBonusNumber(String inputString) throws InvalidFormatException {
        int inputNumber = Integer.parseInt(inputString);
        return validatedPositiveNumber(inputNumber);
    }

    public List<Lotto> parseCustomLottos(String inputString) throws InvalidFormatException {
        return Arrays.stream(inputString.split("\r?\n"))
                .map(String::trim)
                .map(x -> parseLotto(x))
                .collect(Collectors.toList());
    }

    public Lotto parseLotto(String inputString) throws InvalidFormatException {
        List<Integer> numbers = (parseLottoNumbers(inputString));
        return new Lotto(validatedLottoNumbers(numbers));
    }

    public List<Integer> parseLottoNumbers(String inputSting) throws InvalidFormatException {
        return Arrays.stream(inputSting.trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .map(x -> validatedLottoNumber(x))
                .collect(Collectors.toList());
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
