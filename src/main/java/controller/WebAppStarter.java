package controller;

import domain.user.User;
import repository.Repository;
import spark.Spark;
import static spark.Spark.staticFiles;
import view.WebLottoUI;

public class WebAppStarter implements AppStarter {
    private final User user;
    private final int port;
    private final WebLottoUI webLottoUI;
    private final LottoController lottoController;

    public WebAppStarter(LottoController lottoController, User user, int port) {
        this.lottoController = lottoController;
        this.webLottoUI = new WebLottoUI(lottoController);
        this.port = port;
        this.user = user;
    }

    @Override
    public void run() throws Exception {
        Spark.port(port);
        staticFiles.location("/templates");

        System.out.println("Spark Web Server Started...");
        System.out.println("http://127.0.0.1:8080");

        Spark.post("/buyLotto", webLottoUI.buyLottosWebResponse());
        Spark.post("/matchLotto", webLottoUI.matchLottoWebResponse());
    }
}
