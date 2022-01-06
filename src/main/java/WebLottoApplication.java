import controller.Controller;
import controller.WebController;
import view.View;
import view.web.WebLottoView;

import static spark.Spark.*;

public class WebLottoApplication implements Application {
    private final Controller controller;
    private final View view;

    public WebLottoApplication() {
        controller = new WebController();
        view = new WebLottoView(controller);
    }

    @Override
    public void run() throws Exception {
        staticFileLocation("/templates");
        port(8080);

        view.print();
    }
}
