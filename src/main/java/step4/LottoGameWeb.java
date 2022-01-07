package step4;

import step4.controller.WebController;
import step4.service.LottoService;
import step4.view.View;
import step4.view.WebView;

public class LottoGameWeb implements LottoGame{
    private LottoService lottoService;
    private View view = new WebView();
    private WebController controller;

    public LottoGameWeb(LottoService lottoService) {
        this.lottoService = lottoService;
        controller = new WebController(view, lottoService);
    }

    @Override
    public void run() {
        controller.run();
    }
}
