package view.web;

import controller.WebController;
import dto.LastWeekWinningNumber;
import dto.LottoResultDTO;
import dto.PurchasingSheet;
import service.AutoLottoService;
import service.LottoService;
import service.LottoValueObject;
import service.lotto.LottoBundle;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.util.TypeConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class LottoWebMain {
    private static final LottoService autoLottoService = new AutoLottoService();
    private static final WebController webController = new WebController();

    public static void main(String[] args) {
        staticFiles.location("/static");
        post("/buyLotto", webController::purchaseLotto);
        post("/matchLotto", webController::matchLotto);
    }

}
