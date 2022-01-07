import domain.AutoLottoGenerator;
import domain.LottoService;
import domain.ManualLottoGenerator;
import view.LottoServiceInputController;
import view.LottoServiceRenderer;
import view.StandardInLottoServiceInputController;
import view.StandardOutLottoServiceRenderer;

public class Main {
    public static void main(String[] args) {
        LottoServiceRenderer renderer = new StandardOutLottoServiceRenderer();
        LottoServiceInputController inputController = new StandardInLottoServiceInputController();

        LottoService lottoService = new LottoService(inputController, renderer, new ManualLottoGenerator(inputController), new AutoLottoGenerator());
        lottoService.start();
    }
}
