import domain.AutoLottoGenerator;
import domain.LottoService;
import domain.ManualLottoGenerator;
import view.*;

import static spark.Spark.*;

public class SparkMain {
    public static void main(String[] args) {
        SparkLottoInputController inputController = new SparkLottoInputController();
        SparkLottoRenderer renderer = new SparkLottoRenderer();
        LottoService lottoService = new LottoService(inputController, renderer, new ManualLottoGenerator(inputController), new AutoLottoGenerator());

        LottoWebController webController = new LottoWebController(inputController, renderer, lottoService);

        port(8080);
        staticFiles.location("/static");

        post("/buyLotto", webController::purChaseLotto);
        post("/matchLotto", webController::matchLotto);
    }
}
