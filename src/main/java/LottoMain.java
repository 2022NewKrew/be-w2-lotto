import controller.Controller;
import view.InputOutputManager;

public class LottoMain {
    public static void main(String[] args) {
        InputOutputManager inputOutputManager = new InputOutputManager();
        Controller controller = new Controller(inputOutputManager);
        controller.run();
    }
}
