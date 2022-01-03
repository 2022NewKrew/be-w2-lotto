package view.input;

import controller.ConsoleInputController;
import service.LottoValueObject;
import view.util.input.InputConsole;
import view.util.input.PositiveNumberInputConsole;

public class PriceInputView implements InputView {
    private final InputConsole<Integer> positiveNumberInputConsole = new PositiveNumberInputConsole();
    private final ConsoleInputController consoleInputController = new ConsoleInputController();

    @Override
    public Long inputPrice() {
        final int money = positiveNumberInputConsole.read("구매금액을 입력해 주세요.");
        final int quantity = money / LottoValueObject.LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", quantity);
        return consoleInputController.purchaseLotto(quantity);
    }
}
