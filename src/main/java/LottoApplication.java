import controller.InputController;
import controller.LottoController;

public class LottoApplication {
    public static void runApplication() {
        try {
            InputController inputController = new InputController();
            LottoController lottoController = new LottoController(inputController.getPurchasePrice());

            lottoController.printPurchaseAmount();
            lottoController.printLottoNumbers();

            lottoController.setWinningLottoNumbers(inputController.getLottoNumbers());
            lottoController.setBonusNumber(inputController.getBonusNumber());
            lottoController.generateLottoResult();
            lottoController.setProfitRate();

            lottoController.printResult();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        runApplication();
    }
}
