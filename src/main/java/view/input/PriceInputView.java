package view.input;

import controller.ConsoleInputController;
import dto.LastWeekWinningNumberDTO;
import dto.PurchasingSheetDTO;
import service.LottoValueObject;
import view.util.ResourceManager;
import view.util.input.InputConsole;
import view.util.input.PositiveNumberInputConsole;
import view.util.input.PositiveNumberListInputConsole;

import java.util.ArrayList;
import java.util.List;

public class PriceInputView implements InputView {
    private final InputConsole<Integer> positiveNumberInputConsole = new PositiveNumberInputConsole();
    private final InputConsole<List<Integer>> positiveNumberListInputConsole = new PositiveNumberListInputConsole();
    private final ConsoleInputController consoleInputController = new ConsoleInputController();

    @Override
    public Long inputPrice() {
        final int money = positiveNumberInputConsole.read("구매금액을 입력해 주세요.", ResourceManager.SCANNER);
        final int manualLottoQuantity = positiveNumberInputConsole.read("수동으로 구매할 로또 수를 입력해 주세요.", ResourceManager.SCANNER);
        final int autoLottoQuantity = money / LottoValueObject.LOTTO_PRICE - manualLottoQuantity;

        List<List<Integer>> manualLottoNumber = new ArrayList<>();
        for (int i = 0; i < manualLottoQuantity; i++) {
            manualLottoNumber.add(positiveNumberListInputConsole.readWithoutMSG(ResourceManager.SCANNER));
        }
        return consoleInputController.purchaseLotto(new PurchasingSheetDTO(autoLottoQuantity, manualLottoQuantity, manualLottoNumber));
    }

    @Override
    public LastWeekWinningNumberDTO inputWinningNumbers() {
        final List<Integer> lastWeekWinningNumber = positiveNumberListInputConsole.read("지난 주 당첨 번호를 입력해 주세요.", ResourceManager.SCANNER);
        final int bonusNumber = positiveNumberInputConsole.read("보너스 볼을 입력해 주세요.", ResourceManager.SCANNER);
        lastWeekWinningNumber.add(bonusNumber);
        return new LastWeekWinningNumberDTO(lastWeekWinningNumber, bonusNumber);
    }
}
