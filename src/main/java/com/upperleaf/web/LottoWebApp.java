package com.upperleaf.web;

import com.upperleaf.web.db.H2DatabaseInitializer;

import java.sql.*;

import static spark.Spark.*;
import static spark.Spark.port;

public class LottoWebApp {

    public void start(int port) throws SQLException {
        port(port);
        mappingRoute();
        H2DatabaseInitializer.initialize();
    }

    public void mappingRoute() {
        get("/", LottoRoutes.index());
        post("/buyLotto", LottoRoutes.buyLotto());
        post("/matchLotto", LottoRoutes.matchLotto());
    }
}
