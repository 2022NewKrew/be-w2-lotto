package presentation.controller;


import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import dto.output.PurchaseResultDto;
import dto.output.RewardResultDto;
import presentation.converter.Converter;
import service.LottoService;
import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoController {
    private final LottoService lottoService;
    private final Converter<Request, PurchaseDto> purchaseDtoConverter;
    private final Converter<Request, WinningNumbersDto> winningNumbersDtoConverter;
    private final int port;

    public LottoController(int port, LottoService lottoService,
                           Converter<Request, PurchaseDto> purchaseDtoConverter,
                           Converter<Request, WinningNumbersDto> winningNumbersDtoConverter) {
        this.port = port;
        this.lottoService = lottoService;
        this.purchaseDtoConverter = purchaseDtoConverter;
        this.winningNumbersDtoConverter = winningNumbersDtoConverter;
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
        get("/", (req,res)->{
            return render(new HashMap<>(), "index.vm");
        });
    }

    private void addBuyLottoRoute(){
        post("/buyLotto", (req, res)->{
            PurchaseDto purchaseDto = purchaseDtoConverter.convert(req);
            PurchaseResultDto purchaseResultDto = lottoService.purchase(purchaseDto);

            Map<String, Object> model = new HashMap<>();
            model.put("lottosSize", purchaseResultDto.getSize());
            model.put("lottos", purchaseResultDto.getLottoNumberLists());

            return render(model, "show.vm");
        });
    }

    private void addMatchLottoRoute(){
        post("/matchLotto", (req,res)->{
            WinningNumbersDto winningNumbersDto = winningNumbersDtoConverter.convert(req);
            RewardResultDto rewardResultDto = lottoService.matchingWith(winningNumbersDto);

            Map<String, Object> model = new HashMap<>();
            model.put("rewardResults", rewardResultDto.getRewardResults());
            model.put("profitPercent", rewardResultDto.getProfitPercent());

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
            Map<String, Object> model = new HashMap<>();
            model.put("message", req.session().attribute("message"));

           return render(model, "error.vm");
        });
    }

    private static String render(Map<String, Object> model, String templatePath){
        return new VelocityTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
