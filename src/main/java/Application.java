import lotto.controller.LottoController;
import lotto.view.LottoInput;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startWeb();
//        LottoInput lottoInput = new LottoInput();
//        lottoInput.lottoSimulation();
    }
}