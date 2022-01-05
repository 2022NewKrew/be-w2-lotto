import controller.ConsoleController;
import view.View;
import view.console.ConsoleLottoView;

public class LottoApplication {
    private final ConsoleController controller;
    private final View view;

    public LottoApplication() {
        controller = new ConsoleController();
        view = new ConsoleLottoView(controller);
    }

    public void run() throws Exception {
        view.print();
    }
}
