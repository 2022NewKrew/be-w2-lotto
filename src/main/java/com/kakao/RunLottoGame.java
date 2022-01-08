package com.kakao;

import com.kakao.domain.Lotto;
import com.kakao.domain.LottoMachine;
import com.kakao.domain.Result;
import com.kakao.domain.WinningLotto;
import com.kakao.ui.GameInput;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class RunLottoGame {

    private final GameInput gameInput = new GameInput();
    private final LottoMachine lottoMachine = new LottoMachine();

    private int money;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private Result result;

    public static void main(String[] args) {
        RunLottoGame runLottoGame = new RunLottoGame();
        runLottoGame.run();
    }

    public void run() {
        port(8080);
        staticFiles.location("/templates");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            try {
                money = gameInput.inputMoney(req.queryParams("inputMoney"));

                String[] lottoNumbersInput = req.queryParams("manualNumber").split("\r?\n");
                List<List<Integer>> customLottoNumbersList = gameInput.inputCustomLottos(lottoNumbersInput);
                lottos = lottoMachine.buyLottos(money, customLottoNumbersList);

                model.put("lottosSize", money / 1000);
                model.put("lottos", lottos);
                return render(model, "show.html");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                res.redirect("/");
                return null;
            }
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Integer> winningLottoNumbers = gameInput.inputWinningLotto(req.queryParams("winningNumber"));
            int bonusNumber = gameInput.inputBonusNumber(req.queryParams("bonusNumber"), winningLottoNumbers);
            winningLotto = lottoMachine.setWinningLotto(winningLottoNumbers, bonusNumber);
            result = new Result(money, lottos, winningLotto);

            model.put("lottosResult", result);

            return render(model, "result.html");
        });

    }

    private String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
