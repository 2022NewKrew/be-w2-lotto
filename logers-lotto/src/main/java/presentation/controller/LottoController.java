package presentation.controller;


import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import dto.output.PurchaseResultDto;
import dto.output.RewardResultDto;
import presentation.converter.Converter;
import service.LottoService;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoController {
    private final int port;
    private final LottoService lottoService;
    private final Converter<String ,List<List<Integer>>> stringToNumberListsConverter;
    private final Converter<String, List<Integer>> stringToNumbersConverter;

    public LottoController(
            int port, LottoService lottoService,
            Converter<String, List<List<Integer>>> stringToNumberListsConverter,
            Converter<String, List<Integer>> stringToNumbersConverter
    ){
        this.port = port;
        this.lottoService = lottoService;
        this.stringToNumberListsConverter = stringToNumberListsConverter;
        this.stringToNumbersConverter = stringToNumbersConverter;
    }

    public void run(){
        port(this.port);
        addIndexPageRoute();
        addBuyLottoRoute();
        addMatchLottoRoute();
        addErrorHandlingRoute();
        addErrorPageRoute();
    }

    private void addIndexPageRoute(){
        get("/", (req,res)-> render(new HashMap<>(), "index.vm"));
    }

    private void addBuyLottoRoute(){
        post("/buyLotto", (req, res)->{
            int purchasePrice = Integer.parseInt(req.queryParams("inputMoney"));
            List<List<Integer>> numberLists = stringToNumberListsConverter.apply(req.queryParams("manualNumber"));

            PurchaseDto purchaseDto = new PurchaseDto(purchasePrice, numberLists);
            PurchaseResultDto purchaseResultDto = lottoService.purchase(purchaseDto);

            Map<String, Object> model = new HashMap<>(){{
                put("lottosSize", purchaseResultDto.getSize());
                put("lottos", purchaseResultDto.getLottoNumberLists());
            }};

            return render(model, "show.vm");
        });
    }

    private void addMatchLottoRoute(){
        post("/matchLotto", (req,res)->{
            List<Integer> winningNumbers = stringToNumbersConverter.apply(req.queryParams("winningNumbers"));
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            WinningNumbersDto winningNumbersDto = new WinningNumbersDto(winningNumbers, bonusNumber);
            RewardResultDto rewardResultDto = lottoService.matchingWith(winningNumbersDto);

            Map<String, Object> model = new HashMap<>(){{
                put("rewardResults", rewardResultDto.getRewardResults());
                put("profitPercent", rewardResultDto.getProfitPercent());
            }};

            return render(model, "result.vm");
        });
    }

    private void addErrorHandlingRoute() {
        exception(Exception.class, (exception, request, response) -> {
            System.out.println(exception.getMessage());

            request.session().attribute("message", exception.getMessage());
            response.redirect("error");
        });
    }

    private void addErrorPageRoute(){
        get("/error", (req,res)->{
            Map<String, Object> model = new HashMap<>(){{
                put("message", req.session().attribute("message"));
            }};

           return render(model, "error.vm");
        });
    }

    private static String render(Map<String, Object> model, String templatePath){
        return new VelocityTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
