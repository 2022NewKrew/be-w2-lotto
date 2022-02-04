import controller.LottoController;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.getLottoController();
        lottoController.run();
    }
}
