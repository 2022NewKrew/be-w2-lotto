import controller.WebController;
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