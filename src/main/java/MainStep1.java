import lotto.controller.LottoController;
import lotto.util.ResourceManager;

public class MainStep1 {
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        lottoController.start();
        ResourceManager.close();
    }
}
