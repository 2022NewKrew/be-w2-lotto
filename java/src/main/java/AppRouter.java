import api.LottoApi;

import static spark.Spark.*;

public class AppRouter {
    public static void route() {
        LottoApi api = new LottoApi();
        path("/api", () -> {
            post("/buyLotto", api.buyLotto);
            post("/matchLotto", api.matchLotto);
        });
    }
}
