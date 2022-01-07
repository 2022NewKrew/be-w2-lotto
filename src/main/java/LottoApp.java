import domain.Lotto;
import domain.LottoResults;
import domain.LottoShop;
import domain.LottoTicket;
import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import domain.lottonumber.LottoNumber;
import service.LottoGenerator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.console.LottoInputView;
import view.console.LottoOutView;
import view.web.dto.LottoResultsWebDto;
import view.web.dto.LottoShowDto;
import view.web.mapper.LottoTicketMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;


public class LottoApp {

    private static final LottoShop lottoShop = new LottoShop(new LottoGenerator());
    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LottoOutView lottoOutView = new LottoOutView();
    private static Lotto lottoMemory;


    public static void main(String[] args) {
        port(8080);
        staticFileLocation("static");
        post("/buyLotto",(request, response) -> {
            int inputMoney = Integer.parseInt(request.queryParams("inputMoney"));
            String[] manualNumbers = request.queryParams("manualNumber").split("\r\n");
            List<LottoTicket> lottoTickets = Arrays.stream(manualNumbers)
                    .map(LottoTicketMapper::from)
                    .collect(Collectors.toUnmodifiableList());
            Lotto lotto = lottoShop.sell(lottoTickets, inputMoney);
            LottoShowDto lottoShowDto = new LottoShowDto(lotto.getLottoTicketsView());
            lottoMemory = lotto;
            return new HandlebarsTemplateEngine().render(new ModelAndView(lottoShowDto, "/show.html"));
        });

        post("/matchLotto",(request, response) -> {
            List<LottoNumber> winningNumber = Arrays.stream(request.queryParams("winningNumber").split(","))
                    .map(Integer::parseInt)
                    .map(BasicNumber::new)
                    .collect(Collectors.toList());
            winningNumber.add(new BonusNumber(Integer.parseInt(request.queryParams("bonusNumber"))));
            LottoResults lottoResults = lottoMemory.checkLottoResults(winningNumber);
            Map<String, LottoResultsWebDto> model = new HashMap<>();
            LottoResultsWebDto lottoResultsWebDto = new LottoResultsWebDto(lottoResults, lottoMemory);
            model.put("lottosResult", lottoResultsWebDto);
            return new HandlebarsTemplateEngine().render(new ModelAndView(model, "/result.html"));
        });

//        int money = lottoInputView.inputMoney();
//        int numberOfManualLottoTicket = lottoInputView.inputNumberOfManualLottoTicket();
//        Optional<LottoTicketsInputDto> lottoTicketsInputDto = lottoInputView.inputManualLottoTickets(numberOfManualLottoTicket);
//        List<LottoTicket> lottoTickets = lottoTicketsInputDto.map(LottoTicketsInputDto::toLottoTickets).orElse(Collections.emptyList());
//        Lotto lotto = lottoShop.sell(lottoTickets, money);
//        lottoOutView.printLotto(lotto.getLottoTicketsView());
//        LottoResults lottoResults = lotto.checkLottoResults(lottoInputView.inputWinningNumbers());
//
//        lottoOutView.printLottoResults(new LottoResultsDto(lottoResults));
//        lottoOutView.printYield(new YieldDto(lottoResults.getEarnedMoney(), lotto.getPrice()));
    }
}
