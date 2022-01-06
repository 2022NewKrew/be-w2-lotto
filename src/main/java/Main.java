import static spark.Spark.*;

import controller.LottoController;
import dto.request.AllLottoInfo;
import dto.request.LottoPurchaseInfo;
import dto.response.LottoPurchaseAmount;
import dto.response.LottoStatistics;
import service.LottoService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
	public static void main(String[] args) {
		LottoService lottoService = new LottoService();
		LottoController lottoController = new LottoController(lottoService);

		port(80);
		staticFiles.location("/templates");

		post("/buyLotto", (request, response) -> {
			String inputMoney = request.queryParams("inputMoney");
			String manualNumber = request.queryParams("manualNumber");
			LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(inputMoney, manualNumber);

			LottoPurchaseAmount purchaseAmount = lottoController.getPurchaseAmount(lottoPurchaseInfo);

			return new HandlebarsTemplateEngine().render(new ModelAndView(purchaseAmount, "/show.html"));
		});

		post("/matchLotto", (request, response) -> {
			String lottoList = request.queryParams("lottoList");
			String winningNumber = request.queryParams("winningNumber");
			String bonusNumber = request.queryParams("bonusNumber");
			AllLottoInfo allLottoInfo = new AllLottoInfo(lottoList, winningNumber, bonusNumber);

			LottoStatistics lottoStatistics = lottoController.getStatistics(allLottoInfo);

			return new HandlebarsTemplateEngine().render(new ModelAndView(lottoStatistics, "/result.html"));
		});
	}
}
