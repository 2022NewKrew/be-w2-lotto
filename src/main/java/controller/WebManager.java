package controller;

import model.Lotto;
import model.Lottos;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static spark.Spark.*;
import static CONST.Const.*;

public class WebManager {
    public static void run() {
        staticFileLocation("/static");
        port(8080);


        post("/buyLotto", (req, res) -> {
            // 웹으로 부터 로또 금액 입력 받음
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            // 웹으로 부터 매뉴얼 번호 입력 받음
            String manualNumber = req.queryParams("manualNumber");

            // List<String>을 List<Lotto>로 처리하고 Lottos로 만듬
            List<String> manualNumberSet = List.of(manualNumber.split("\r?\n"));
            int manualCount = manualNumberSet.size();
            Lottos manualLottos = new Lottos(
                    manualNumberSet
                            .stream()
                            .map(s -> new Lotto(Stream.of(s.split(",")).map(Integer::parseInt).collect(Collectors.toList())))
                            .collect(Collectors.toList())
            );

            // 수동(기존) + 자동 로또 생성
            Lottos lottos = new Lottos(manualLottos, inputMoney);
            req.session().attribute("lottos", lottos);

            // html에 전달하기 위해서 model에 담음;
            Map<String, Object> model = new HashMap<>();
            model.put("lottosSize", inputMoney / LOTTO_PRICE);
            model.put("lottos", lottos.getLottos());
            return render(model, "show.html");
        });


        post("/matchLotto", (req, res) -> {
            // 웹에서 당첨번호 입력받음
            List<Integer> winningNumber = Arrays.stream(req.queryParams("winningNumber").split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 웹에서 보너스 번호 입력받음
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            // 당첨 확인 로직
            Lottos lottos = req.session().attribute("lottos");
            System.out.println(lottos);
            System.out.println(lottos.getClass());
            HashMap<Integer, Integer> resultMap = lottos.checkResult(winningNumber, bonusNumber);
            StringBuilder resultString = new StringBuilder();
            resultString.append(SHOW_RESULT).append("\n");
            resultString.append(CORRECT_THREE).append(resultMap.get(3)).append("\n");
            resultString.append(CORRECT_FOUR).append(resultMap.get(4)).append("\n");
            resultString.append(CORRECT_FIVE).append(resultMap.get(5)).append("\n");
            resultString.append(CORRECT_FIVE_BONUS).append(resultMap.get(7)).append("\n");
            resultString.append(CORRECT_SIX).append(resultMap.get(6));

            double winRate = lottos.checkWinRate(resultMap);
            DecimalFormat form = new DecimalFormat("#.##");
            String totalRateOfReturn = form.format(winRate);

            // html에 전달하기 위해서 model에 담음;
            Map<String, Object> model = new HashMap<>();
            model.put("lottoResult", resultString.toString());
            model.put("totalRateOfReturn", totalRateOfReturn);

            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}