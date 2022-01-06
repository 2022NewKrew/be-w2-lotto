package lottery.web;

import lottery.domain.Constants;
import lottery.web.dto.BudgetAndManualLotteryDto;
import lottery.web.dto.LotteryDto;
import lottery.web.dto.LotteryResultDto;
import lottery.web.dto.LotteryWinningNumberWithBonusDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebIOController {

    private final LotteryController lotteryController = new LotteryController();

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public void run() {
        port(8080);

        get("/", (req, res) -> {
            return render(null, "index.html");
        });

        post("buyLotto", (req, res) -> {
            Map model = new HashMap();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String manualNumberBundle = req.queryParams("manualNumber");
            ArrayList<ArrayList<Integer>> manualLotteryBundle = new ArrayList<>();

            for (String line : manualNumberBundle.split("\r?\n")) {
                manualLotteryBundle.add(tokenizeLotteryNumber(line));
            }

            inputMoney -= Constants.PRICE * manualLotteryBundle.size();

            BudgetAndManualLotteryDto budgetAndManualLotteryDto = new BudgetAndManualLotteryDto(inputMoney, manualLotteryBundle);
            List<LotteryDto> boughtLotteries = lotteryController.buy(budgetAndManualLotteryDto);
            model.put("lottosSize", boughtLotteries.size());
            List<Map> table = new ArrayList<>();
            for (int idx = 0; idx < boughtLotteries.size(); idx++) {
                Map temp = new HashMap();
                temp.put("numbers", boughtLotteries.get(idx).getNumbers().toString());
                table.add(temp);
            }

            model.put("lottos", table);
            return render(model,"show.html");
        });

        post("matchLotto", (req, res) -> {
            ArrayList<Integer> winningNumbers = tokenizeLotteryNumber(req.queryParams("winningNumber"));
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            LotteryWinningNumberWithBonusDto lotteryWinningNumberWithBonusDto = new LotteryWinningNumberWithBonusDto(winningNumbers, bonusNumber);
            LotteryResultDto matchResult = lotteryController.match(lotteryWinningNumberWithBonusDto);
            matchResult.toString();

            Map model = new HashMap();
            Map lottosResult = new HashMap();
            ArrayList<String> messages = matchResult.getMessages();

            lottosResult.put("message", messages);

            lottosResult.put("totalRateOfReturn", matchResult.getEarningRate());
            model.put("lottosResult", lottosResult);
            return render(model, "result.html");
        });

    }

    private ArrayList<Integer> tokenizeLotteryNumber(String numbers) {
        ArrayList<Integer> tokenizedArr = new ArrayList<>();

        for(String el : numbers.split(",")) {
            tokenizedArr.add(Integer.parseInt(el.trim()));
        }

        return tokenizedArr;
    }
}
