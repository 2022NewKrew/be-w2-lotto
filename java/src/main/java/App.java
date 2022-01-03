import view.LottoMachine;

public class App {

    private LottoMachine lottoMachine;

    public App() {
        lottoMachine = new LottoMachine();
    }

    public static void main(String[] args) {
        App app = new App();
        app.lottoMachine.run();
    }
}
