package view.web;

import controller.Controller;
import dto.request.LottoCheckDTO;
import dto.request.LottoPurchaseDTO;
import dto.response.CheckedLottoDTO;
import dto.response.PurchasedLottoDTO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.web.InputInterface;
import util.web.OutputInterface;

import java.util.Map;

import static spark.Spark.*;

public class WebLottoView implements WebView {
    private final InputInterface inputInterface = new InputInterface();
    private final OutputInterface outputInterface = new OutputInterface();
    private final Controller controller;

    public WebLottoView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void print() throws Exception {
        post("/buyLotto", this::printPurchaseView);
        post("/matchLotto", this::printCheckView);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private String printPurchaseView(Request req, Response res) {
        LottoPurchaseDTO lottoPurchaseDTO = inputInterface.convertRequestToPurchaseDto(req);
        PurchasedLottoDTO purchasedLottoDTO = controller.purchase(lottoPurchaseDTO);
        saveCacheOfLottoId(purchasedLottoDTO);

        Map<String, Object> model = outputInterface.convertPurchasedDtoToModel(purchasedLottoDTO);

        return render(model, "/show.html");
    }

    private String printCheckView(Request req, Response res) {
        LottoCheckDTO lottoCheckDTO = inputInterface.convertRequestToCheckDto(req);
        lottoCheckDTO.setLottoId(loadCacheOfLottoId());
        CheckedLottoDTO checkedLottoDTO = controller.check(lottoCheckDTO);

        Map<String, Object> model = outputInterface.convertCheckedDtoToModel(checkedLottoDTO);

        return render(model, "/result.html");
    }

    private void saveCacheOfLottoId(PurchasedLottoDTO purchasedLottoDTO) {
        setAttribute(lottoId, purchasedLottoDTO.getId());
    }

    private Long loadCacheOfLottoId() {
        return getAttribute(lottoId);
    }
}
