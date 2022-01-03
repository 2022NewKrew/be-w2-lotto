import controller.InputController;

public class LottoApplication {
    public static void runApplication() {
        try {
            InputController inputController = new InputController();

            inputController.getPurchasePrice();
            inputController.getLottoNumbers();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        runApplication();
    }
}
