import controller.WebController;
import domain.*;
import dto.LottosResult;
import view.ConsoleInputView;
import view.ConsoleOutputView;

import java.util.List;

import static domain.Player.LOTTO_PRICE;
import static spark.Spark.*;

public class main {

    public static void main(String[] args) {
        staticFileLocation("/static");
        port(8080);
        setUpRoutes();
    }
    private static void setUpRoutes() {
        post("/buyLotto", WebController::buyLotto);
        post("/matchLotto", WebController::matchLotto);
    }
}