package view.input;

import controller.ConsoleInputController;
import dto.LastWeekWinningNumberDTO;
import service.LottoValueObject;
import view.util.ResourceManager;
import view.util.input.InputConsole;
import view.util.input.PositiveNumberInputConsole;
import view.util.input.PositiveNumberListInputConsole;

import java.util.List;
import java.util.Scanner;

public class PriceInputView implements InputView {
    private final InputConsole<Integer> positiveNumberInputConsole = new PositiveNumberInputConsole();
    private final InputConsole<List<Integer>> positiveNumberListInputConsole = new PositiveNumberListInputConsole();
    private final ConsoleInputController consoleInputController = new ConsoleInputController();

    @Override
    public Long inputPrice() {
        final int money = positiveNumberInputConsole.read("구매금액을 입력해 주세요.", ResourceManager.SCANNER);
        final int quantity = money / LottoValueObject.LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", quantity);
        return consoleInputController.purchaseLotto(quantity);
    }

    @Override
    public LastWeekWinningNumberDTO inputWinningNumbers() {
        List<Integer> lastWeekWinningNumber = positiveNumberListInputConsole.read("지난 주 당첨 번호를 입력해 주세요.", ResourceManager.SCANNER);
        Integer bonusNumber = positiveNumberInputConsole.read("보너스 볼을 입력해 주세요.", ResourceManager.SCANNER);
        lastWeekWinningNumber.add(bonusNumber);
        return new LastWeekWinningNumberDTO(lastWeekWinningNumber, bonusNumber);
    }
}
