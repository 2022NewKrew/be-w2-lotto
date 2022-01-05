package be.w2.lotto.boot;

import be.w2.lotto.cashier.Cashier;
import be.w2.lotto.cashier.OrderSheet;
import be.w2.lotto.exceptions.NonValidNumberOfLottoException;
import be.w2.lotto.exceptions.NonValidPurchaseAmountException;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.messages.ErrorMessage;
import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.precondition.Precondition;
import be.w2.lotto.view.input.Input;
import be.w2.lotto.view.output.Output;

import java.util.List;

/**
 * Singleton
 */
public final class GameStarter {

    private static GameStarter INSTANCE;

    private GameStarter() {
    }

    public static GameStarter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    public void start() {
        OrderSheet orderSheet = createOrder();
        List<Lotto> lottos = createLottosBy(orderSheet);

        outputOrder(orderSheet);
        outputLottos(lottos);

        ResultMaker.getInstance().proceedBy(lottos);
    }

    private OrderSheet createOrder() {
        int purchaseAmount = inputPurchaseAmount();
        int numOfManual = inputNumOfManual();
        return Cashier.createOrderSheet(purchaseAmount, numOfManual);
    }

    private int inputPurchaseAmount() {
        int purchaseAmount = Input.inputIntWithMessage(GameMessage.INPUT_PURCHASE_AMOUNT);
        Precondition.notLessThanInt(purchaseAmount, 0, new NonValidPurchaseAmountException(ErrorMessage.PURCHASE_AMOUNT_SHOULD_BE_POSITIVE));
        return purchaseAmount;
    }

    private int inputNumOfManual() {
        int numOfManual = Input.inputIntWithMessage(GameMessage.INPUT_NUM_OF_MANUAL);
        Precondition.notLessThanInt(numOfManual, 0, new NonValidNumberOfLottoException(ErrorMessage.NUM_OF_LOTTO_CAN_NOT_BE_NEGATIVE));
        return numOfManual;
    }

    private List<Lotto> createLottosBy(OrderSheet orderSheet) {
        return Cashier.createLottoByOrder(orderSheet);
    }

    private void outputOrder(OrderSheet orderSheet) {
        Output.outputOrderSheet(orderSheet);
    }

    private void outputLottos(List<Lotto> lottos) {
        Output.outputLottos(lottos);
    }

}
