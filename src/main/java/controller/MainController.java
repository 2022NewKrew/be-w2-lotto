package controller;

import config.AppConfig;
import domain.Lotto;
import domain.LottoStatistic;
import repository.LottoRepository;
import service.LottoService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class MainController {
    private final LottoService lottoService;
    private final LottoRepository lottoRepository;

    public MainController() {
        AppConfig appConfig = new AppConfig();
        lottoService = appConfig.lottoService();
        lottoRepository = appConfig.lottoRepository();
    }

    public void run() {
        staticFiles.location("/static");
        get("/lottoForm", this::lottoForm);
        post("/lottoForm", this::createLottoForm);
        post("/lottoWinning", this::lottoWinning);
    }

    private String lottoWinning(Request req, Response res) {
        Long id = Long.valueOf(req.queryParams("id").trim());
        String winningNumbersString = req.queryParams("winningNumbers");

        List<Integer> winningNumbers = Arrays.stream(winningNumbersString.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        int winningBonusNumber = Integer.parseInt(req.queryParams("winningBonusNumber"));

        LottoStatistic lottoStatistic = lottoRepository.findOne(id);

        lottoStatistic.updateStatus(winningNumbers, winningBonusNumber);

        Map<String, Object> model = new HashMap<>();
        model.put("lottoStatistic", lottoStatistic);

        return render(model, "lotto_statistics.html");
    }

    private String lottoForm(Request req, Response res) {
        return render("lotto_form.html");
    }

    private String createLottoForm(Request req, Response res) {
        int purchasePrice = Integer.parseInt(req.queryParams("purchasePrice"));

        int normalLottoCount = Integer.parseInt(req.queryParams("normalLottoCount"));
        int purchaseCount = lottoService.calculateLottoCount(purchasePrice);
        int autoLottoCount = purchaseCount - normalLottoCount;
        String normalLottoString = req.queryParams("normalLottoString");

        List<Lotto> lottoList = lottoService.createAutoLottoList(autoLottoCount);

        if (normalLottoCount != 0) {
            String[] normalLottoStringList = normalLottoString.split("\n");

            for (String str : normalLottoStringList) {
                lottoList.add(lottoService.createStringToLottoNumbers(str));
            }
        }

        LottoStatistic lottoStatistics = lottoService.createLottoStatistic(purchaseCount, normalLottoCount, autoLottoCount, lottoList);
        Long id = lottoRepository.save(lottoStatistics);
        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        model.put("normalLottoCount", normalLottoCount);
        model.put("autoLottoCount", autoLottoCount);
        model.put("lottoList", lottoList);

        return render(model, "lotto_list.html");
    }

    public static String render(String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(null, templatePath));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
