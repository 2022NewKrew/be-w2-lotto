package view.console;

import controller.Controller;
import dto.request.LottoCheckDTO;
import dto.response.CheckedLottoDTO;
import util.console.BonusNumberInputInterface;
import util.console.WinningNumbersInputInterface;

import java.util.List;

public class LottoResultView implements ConsoleView {
    private final Controller consoleController;

    private final WinningNumbersInputInterface winningNumbersInputInterface = new WinningNumbersInputInterface();
    private final BonusNumberInputInterface bonusNumberInputInterface = new BonusNumberInputInterface();

    public LottoResultView(Controller consoleController) {
        this.consoleController = consoleController;
    }

    @Override
    public void print() {
        final LottoCheckDTO lottoCheckDTO = inputLottoCheck();

        lottoCheckDTO.setLottoId(loadCacheOfLottoId());

        CheckedLottoDTO checkedLottoDTO = consoleController.check(lottoCheckDTO);

        System.out.println(checkedLottoDTO.getLottoResult());
    }

    private LottoCheckDTO inputLottoCheck() {
        final List<Integer> winningNumbers = winningNumbersInputInterface.read();
        final Integer bonusNumber = bonusNumberInputInterface.read();

        return new LottoCheckDTO(winningNumbers, bonusNumber);
    }

    private Long loadCacheOfLottoId() {
        return getAttribute(lottoId);
    }
}
