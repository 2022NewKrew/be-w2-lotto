import domain.*;
import dto.LottosResult;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.OutputView;
import view.InputView;

import static domain.Player.LOTTO_PRICE;
import static spark.Spark.*;
import java.util.*;
import java.util.stream.Collectors;

public class main {

    private static Player player;
    public static void main(String[] args) {
        //staticFileLocation("/static");
        //port(8080);

        post("/buyLotto", (req, res) -> {
            int playerMoney = Integer.parseInt(req.queryParams("inputMoney"));

            List<Lotto> arrayList = new ArrayList<>();
            List<List<Integer>> manualNumbers = Arrays.stream(req.queryParams("manualNumber").
                            split("\r\n")).
                            map(t -> Arrays.stream(t.split(",")).
                            map(Integer::parseInt).
                            collect(Collectors.toList())).
                            collect(Collectors.toList());
            for(List<Integer> manualNumber : manualNumbers)
            {
                arrayList.add(new Lotto(manualNumber));
            }
            player = new Player(playerMoney, arrayList);
            System.out.println(req.queryParams("manualNumber"));
            Map model = new HashMap<>();
            model.put("lottosSize", player.getPayTotalCount());
            model.put("lottos",player.getLottoList());
            return render(model, "/show.html");
        });
        post("/matchLotto", (req, res) -> {
            Matching matching = new Matching();
            matching.addMatchingLotto(player,
                    Arrays.asList(req.queryParams("winningNumber").split(",")).stream().map(Integer::parseInt).collect(Collectors.toList()),
                    Integer.valueOf(req.queryParams("bonusNumber")));
            Map model = new HashMap<>();
            LottosResult lottosResult = new LottosResult();
            lottosResult.makeRender(matching, player);

            model.put("lottosResult", lottosResult);
            return render(model, "/result.html");

        });
        int playerMoney = InputView.getPayPriceInput();
        int payManualCount = InputView.getManualCountInput(playerMoney/LOTTO_PRICE);
        List<Lotto> manualLottoList = InputView.getManualLottoInput(payManualCount);
        Player player = new Player(playerMoney, manualLottoList);
        OutputView.printLottoList(player);
        OutputView.printLottoSize(player.getPayAutoCount(), player.getPayManualCount());

        Matching matching = new Matching();
        matching.addMatchingLotto(player, InputView.getWinningInput(), InputView.getBonusWinningInput());
        OutputView.printMatchResult(matching, playerMoney);
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}