import domain.LottoService;
import view.LottoServiceInputController;
import view.LottoServiceRenderer;
import view.StandardInLottoServiceInputController;
import view.StandardOutLottoServiceRenderer;

public class Main {
    public static void main(String[] args) {
        LottoServiceRenderer renderer = new StandardOutLottoServiceRenderer();
        LottoServiceInputController inputController = new StandardInLottoServiceInputController(renderer);

        LottoService lottoService = new LottoService(inputController, renderer);
        lottoService.start();
    }
}
