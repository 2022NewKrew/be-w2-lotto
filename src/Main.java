//import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {

    public static final InputView inputView = InputView.getInstance();
    public static final OutputView outputView = OutputView.getInstance();

    public static void main(String[] args) {

        User user = new User();

        int price = inputView.inputPrice();

        int numberOfManual = inputView.inputNumberOfManual();
        List<String> manualList = inputView.inputManual(numberOfManual);

        user.purchase(price, numberOfManual, manualList);

        outputView.printNumberOfBuy(user.getNumberOfManual(), user.getNumberOfBuy() - user.getNumberOfManual());
        outputView.printLottoList(user.getLottoList());

        String winningLotto = inputView.inputWinning();
        int bonusBall = inputView.inputBonus();
        LottoMachine.getInstance().createWinningLotto(winningLotto, bonusBall);

        user.lotteryDraw();
        user.calculateProfit();

        outputView.printResult(user);
    }
}
