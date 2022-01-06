package be.w2.lotto.boot;

import be.w2.lotto.lottos.Lotto;

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
        List<Lotto> orderedLottos = OrderPhase.getInstance().start();
        ResultPhase.getInstance().start(orderedLottos);
    }
}
