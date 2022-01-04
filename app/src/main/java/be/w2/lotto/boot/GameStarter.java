package be.w2.lotto.boot;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.machines.AutoPurchaseMachine;
import be.w2.lotto.messages.GameMessage;
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
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = purchase(purchaseAmount);
        outputLottos(lottos);

        ResultMaker.getInstance().proceedBy(lottos);
    }

    private int inputPurchaseAmount() {
        return Input.inputIntWithMessage(GameMessage.INPUT_PURCHASE_AMOUNT);
    }

    private List<Lotto> purchase(int purchaseAmount) {
        AutoPurchaseMachine machine = new AutoPurchaseMachine();
        return machine.purchaseLottos(purchaseAmount);
    }

    private void outputLottos(List<Lotto> lottos) {
        Output.outputLottos(lottos);
    }
}
