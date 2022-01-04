package carrot.ez.view;

import carrot.ez.controller.LottoController;
import carrot.ez.service.LottoService;
import carrot.ez.util.IOUtil;

public class LottoStarter {

    private final static IOUtil io = new IOUtil();
    private final static LottoController lottoController = new LottoController(new LottoService());

    public static void start() {
        new LottoView(io, lottoController).render();
    }

    private LottoStarter() {
    }
}
