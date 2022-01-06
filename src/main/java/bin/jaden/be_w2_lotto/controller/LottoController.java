package bin.jaden.be_w2_lotto.controller;

import bin.jaden.be_w2_lotto.service.LottoService;

import static spark.Spark.*;

public class LottoController {
    private final LottoService service;

    public LottoController() {
        service = new LottoService();
        port(8080);

        get("/", service::index);
        post("/buyLotto", service::buyLotto);
        post("/matchLotto", service::matchLotto);
    }

}
