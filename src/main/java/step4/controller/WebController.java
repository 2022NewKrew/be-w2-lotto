package step4.controller;

import static spark.Spark.*;

import spark.Route;
import step4.service.domain.WinningLotto;
import step4.util.LottoUtil;
import step4.util.TypeConverter;
import step4.service.LottoService;
import step4.service.domain.LottoBundle;
import step4.view.View;
import step4.view.dto.LottoGameResult;

import java.util.*;
import java.util.stream.Collectors;

public class WebController {

    private final View view;
    private final LottoService lottoService;

    public WebController(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void run() {
        port(8080);
        get("/", getIndexPage());
        post("/buyLotto", postBuyLotto());
        post("/matchLotto", postMatchLotto());
    }

    public Route getIndexPage() {
        return (req, res) -> view.getStartPage();
    }

    public Route postBuyLotto() {
        return (request, response) -> {
            int amountOfTicket = TypeConverter.convertMoney(request.queryParams("inputMoney"));
            List<List<Integer>> manualNumber = parseManualLottoNums(request.queryParams("manualNumber"));

            LottoBundle tickets = lottoService.buy(amountOfTicket, manualNumber);
            lottoService.save(request.session().id(), tickets);

            Map map = LottoUtil.createShowPageModel(tickets);
            return view.showTickets(map);
        };
    }

    private Route postMatchLotto() {
        return (request, response) -> {
            WinningLotto winningLotto = lottoService.createWinningLotto(request.queryParams("winningNumber"), request.queryParams("bonusNumber"));
            LottoBundle lottoBundle = lottoService.findById(request.session().id());

            Map<Integer, Integer> matchResult = lottoService.matchAndGetResult(lottoBundle, winningLotto);
            double profitRate = lottoService.calculateProfitRate(lottoBundle.getTicketAmount(), matchResult);
            String plainFormatOfProfit = LottoUtil.removeExp(profitRate);

            Map resultModel = LottoUtil.createResultModel(new LottoGameResult(matchResult, plainFormatOfProfit));
            return view.showResult(resultModel);
        };
    }



    private List<List<Integer>> parseManualLottoNums(String manualNumber){
        if(manualNumber.isBlank()) return new ArrayList<List<Integer>>();
        List<String> manualLottoNums = Arrays.asList(manualNumber.split("\r?\n"));
        return manualLottoNums.stream()
                .map(TypeConverter::StringToIntegerList)
                .collect(Collectors.toList());
    }
}
