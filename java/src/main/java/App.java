import domain.LottoController;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        //runCLI();
        runWeb();
    }

    private static void runCLI() {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }

    private static void runWeb() {
        setConfig();
        AppRouter.route();
    }

    private static void setConfig() {
        port(8080);
        staticFileLocation("/static");
    }
}
