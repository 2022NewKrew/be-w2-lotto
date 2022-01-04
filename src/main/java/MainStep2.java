import lotto.controller.LottoBonusController;
import lotto.util.ResourceManager;

public class MainStep2 {
    private static final LottoBonusController lottoBonusController = new LottoBonusController();

    public static void main(String[] args) {
        lottoBonusController.start();
        ResourceManager.close();
    }
}
