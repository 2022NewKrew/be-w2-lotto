package controller;

import domain.Lotto;
import domain.Matching;
import domain.Player;
import dto.LottosResult;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

public class WebController {
    private static Player player;
    public static String buyLotto(Request req, Response res) {
            int playerMoney = Integer.parseInt(req.queryParams("inputMoney"));
            List<Lotto> manualLottoList = generateMaualLottoList(req.queryParams("manualNumber"));

            player = new Player(playerMoney, manualLottoList);

            Map model = new HashMap<>();
            model.put("lottosSize", player.getPayTotalCount());
            model.put("lottos", player.getLottoList());
            return render(model, "/show.html");
    }
    public static String matchLotto(Request req, Response res) {
        Matching matching = new Matching();
        List<Integer> winningNumber = generateWinningNumber(req.queryParams("winningNumber"));
        Integer bonusNumber = Integer.valueOf(req.queryParams("bonusNumber"));
        matching.addMatchingLotto(player,winningNumber,bonusNumber);

        LottosResult lottosResult = new LottosResult(matching, player);

        Map<Object, Object> model = new HashMap<>();
        model.put("lottosResult", lottosResult);
        return render(model, "/result.html");
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
    private static List<Integer> generateWinningNumber(String WinningNumberStr) {
        return Arrays.stream(WinningNumberStr.split(",")).map(Integer::parseInt).
                collect(Collectors.toList());
    }

    private static List<Lotto> generateMaualLottoList(String manualNumber) {
        if(manualNumber.length() == 0)
            return new ArrayList<>();
        List<Lotto> manualLottoList = new ArrayList<>();
        List<List<Integer>> manualNumbers = Arrays.stream(manualNumber.
                        split("\r\n")).
                map(t -> Arrays.stream(t.split(",")).
                        map(Integer::parseInt).
                        collect(Collectors.toList())).
                collect(Collectors.toList());
        for(List<Integer> manualLottoNumber : manualNumbers)
        {
            manualLottoList.add(new Lotto(manualLottoNumber));
        }
        return manualLottoList;
    }
}
