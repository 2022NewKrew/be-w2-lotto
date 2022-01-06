package be.w2.lotto;

import be.w2.lotto.Domain.LottoService;
import be.w2.lotto.View.UserInterface;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoApplication {

    private final UserInterface userInterface;
    private final LottoService lottoService;

    public LottoApplication() {
        this.userInterface = new UserInterface();
        this.lottoService = new LottoService();
    }

    public static String render(Map model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.webApplication();
//        lottoApplication.cliApplication();
    }

    private void cliApplication(){
        this.makeLottoTickets();
        this.makeAnswer();
    }
//
    private void webApplication(){
        staticFiles.location("/static");
        Spark.exception(Exception.class, (e, request, response) -> {
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw, true);
            e.printStackTrace(pw);
            System.err.println(sw.getBuffer().toString());
        });

        get("/", (req, res)->{
            return new HandlebarsTemplateEngine().render(new ModelAndView(null, "index.html"));
        });

        post("/buyLotto", (req,res)->{
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String manualNumber = req.queryParams("manualNumber");
            lottoService.makeMoney(inputMoney);
            List<List<Integer>> tmp2 = Arrays.asList(manualNumber.split("\n"))
                    .stream()
                    .map(s->userInterface.stringToIntList(s))
                    .collect(Collectors.toList());
            lottoService.makeAmount(tmp2.size());
            lottoService.sell(tmp2);
            Map<String, Object> model = new HashMap<>();
            List<String> lottoTickets = lottoService.getLottoTicketsForWeb();
            model.put("lottoTickets", lottoTickets);
            model.put("lottosSize", lottoTickets.size());

            return render(model, "show.html");
        });

        post("/matchLotto", (req, rest)->{
            Map<String, Object> model = new HashMap<>();
            List<Integer> nums = userInterface.stringToIntList(req.queryParams("winningNumber"));
            int bonusNum = Integer.parseInt(req.queryParams("bonusNumber"));
            lottoService.makeLottoResult(nums, bonusNum);
            model.put("lottosResult", userInterface.makeWebLottosResult(lottoService.getStatistics(), lottoService.calculateBenefit()));
            return render(model, "result.html");
        });
    }


    private void makeLottoTickets() {
        makeMoney();
        makeAmount();
        makeManualInputs();
        userInterface.printBuyAmount(lottoService.getLottoTickets());
        userInterface.printTickets(lottoService.getLottoTickets());
    }

    private void makeManualInputs() {
        while (!isValidManualInputs()) ;
    }

    private boolean isValidManualInputs() {
        boolean isValid = false;
        try {
            userInterface.queryManualNumbers();
            List<List<Integer>> manualInputs = userInterface.readManualInputs(lottoService.getManualAmount());
            lottoService.sell(manualInputs);
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }

    private void makeAmount() {
        while (!isValidAmount()) ;
    }

    private boolean isValidAmount() {
        boolean isValid = false;
        try {
            userInterface.queryManualAmount();
            lottoService.makeAmount(userInterface.readInt());
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }


    private void makeMoney() {
        while (!isValidMoney()) ;
    }

    private boolean isValidMoney() {
        boolean isValid = false;
        try {
            userInterface.queryBuyMoney();
            lottoService.makeMoney(userInterface.readInt());
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }

    private void makeAnswer() {
        makeBenefit();
        userInterface.printStatistics(lottoService.getStatistics());
        userInterface.printBenefit(lottoService.calculateBenefit());
    }

    private void makeBenefit() {
        while (!isValidBenefit()) ;
    }

    private boolean isValidBenefit() {
        boolean isValid = false;
        try {
            userInterface.queryAnswerNumber();
            List<Integer> nums = userInterface.readIntList();
            userInterface.queryBonusNumber();
            int bonusNum = userInterface.readInt();
            lottoService.makeLottoResult(nums, bonusNum);
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }

}
