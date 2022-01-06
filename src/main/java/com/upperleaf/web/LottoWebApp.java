package com.upperleaf.web;

import static spark.Spark.*;
import static spark.Spark.port;

public class LottoWebApp {

    public void start(int port) {
        port(port);
        mappingRoute();
    }

    public void mappingRoute() {
        get("/", LottoRoutes.index());
        post("/buyLotto", LottoRoutes.buyLotto());
        post("/matchLotto", LottoRoutes.matchLotto());
    }
}
