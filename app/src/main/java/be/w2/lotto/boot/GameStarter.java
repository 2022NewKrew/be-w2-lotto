package be.w2.lotto.boot;

import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.view.View;

public class GameStarter {
    private static GameStarter INSTANCE;

    private GameStarter() {
    }

    public static GameStarter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    private View view = new View();

    public void start() {
        int purchaseAmount = view.inputIntWithMessage(GameMessage.INPUT_PURCHASE_AMOUNT);

    }
}
