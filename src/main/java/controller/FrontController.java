package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LottoDto;
import dto.LottoListCreateDto;
import dto.WinningLottoCreateDto;
import exception.IllegalInputException;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class FrontController {
    private final Controller controller;

    public FrontController(Controller controller) {
        this.controller = controller;
    }

    public void map() {
        ObjectMapper objectMapper = new ObjectMapper();

        port(8080);

        get("/", (req, res) -> {
            controller.deleteLottoList();
            return render(null, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            List<LottoDto> manualLottoDtoList = new ArrayList<>();
            int budget = parseInt(req.queryParams("inputMoney"));
            for (String line: req.queryParams("manualNumber").split("\\r\\n")) {
                List<Integer> lottoSequence = getIntList(line.split(", "));
                manualLottoDtoList.add(new LottoDto(lottoSequence, false));
            }
            controller.createLottoList(new LottoListCreateDto(budget, manualLottoDtoList));

            Map<String, Object> model = new HashMap<>();
            List<LottoDto> lottoDtoList = controller.getLottoList();
            model.put("lottoList", lottoDtoList);
            model.put("length", lottoDtoList.size());
            return render(objectMapper.convertValue(model, Map.class), "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            List<Integer> winningSequence = getIntList(req.queryParams("winningNumber").split(", "));
            int bonusNumber = parseInt(req.queryParams("bonusNumber"));

            WinningLottoCreateDto winningLottoCreateDto = new WinningLottoCreateDto(winningSequence, bonusNumber);
            controller.createWinningLotto(winningLottoCreateDto);

            Map<String, Object> model = new HashMap<>();
            model.put("result", controller.getResults());
            return render(model, "/result.html");
        });
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalInputException("정수형을 입력하세요.");
        }
    }

    private List<Integer> getIntList(String[] input) {
        return Arrays
                .stream(input)
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

    public static String render(Map<?, ?> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
