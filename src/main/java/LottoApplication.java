import controller.InputController;

public class LottoApplication {
    public static void runApplication() {
        InputController inputController = new InputController();

        inputController.getPurchaseAmount();
        inputController.getLottoNumbers();
    }

    public static void main(String[] args) {
        runApplication();
    }
}
