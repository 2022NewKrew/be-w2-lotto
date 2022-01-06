import controller.ConsoleController;
import controller.Controller;
import view.View;
import view.console.ConsoleLottoView;

public class ConsoleLottoApplication implements Application {
    private final Controller controller;
    private final View view;

    public ConsoleLottoApplication() {
        controller = new ConsoleController();
        view = new ConsoleLottoView(controller);
    }

    @Override
    public void run() throws Exception {
        view.print();
    }
}
