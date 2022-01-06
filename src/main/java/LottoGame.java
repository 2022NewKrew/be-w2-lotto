import controller.LottoGameController;

import static spark.Spark.*;

public class LottoGame {

    private static final LottoGameController game = new LottoGameController();
    private static final int WEB_SERVER_PORT = 8080;
    private static final int BAD_REQUEST = 400;

    public static void main(String[] args) {
        port(WEB_SERVER_PORT);
        mapping();
    }

    private static void mapping() {
        get("/", game::index);

        post("/buyLotto", game::createLotto);

        post("/matchLotto", game::getLottoResult);

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(BAD_REQUEST);
            res.body(e.getMessage());
        });
    }
}
