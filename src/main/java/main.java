import domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.OutputView;
import view.InputView;
import static spark.Spark.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class main {


    public static void main(String[] args) {
        staticFileLocation("/static");
        port(8080);

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
            Player player = new Player(playerMoney, arrayList);
            System.out.println(req.queryParams("manualNumber"));
            Map model = new HashMap<>();
            model.put("lottosSize", player.getPayAutoCount() + player.getPayManualCount());
            model.put("lottos",player.getLottoList());
            return render(model, "/show.html");
        });
        /*
        int playerMoney = InputView.getPayPriceInput();
        InputView.getManualLottoInput(payManualCount)
        Player player = new Player(playerMoney);
        OutputView.printLottoList(player);
        OutputView.printLottoSize(player.getPayAutoCount(), player.getPayManualCount());

        Matching matching = new Matching();
        matching.addMatchingLotto(player);

        OutputView.printMatchResult(matching, playerMoney);
        */

    }
    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}