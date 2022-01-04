package be.w2.lotto.boot;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.lottos.LottoService;
import be.w2.lotto.machines.AutoPurchaseMachine;
import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.result.ResultMaker;
import be.w2.lotto.view.View;

import java.util.List;

/**
 * Singleton
 */
public class GameStarter {

    private static GameStarter INSTANCE;

    private GameStarter() {
    }

    public static GameStarter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    private final View view = View.getInstance();

    public void start() {
        int purchaseAmount = view.inputIntWithMessage(GameMessage.INPUT_PURCHASE_AMOUNT);
        List<Lotto> lottos = purchase(purchaseAmount);
        outputLottos(lottos);
        ResultMaker.getInstance().produceResults(lottos);
    }

    private List<Lotto> purchase(int purchaseAmount) {
        AutoPurchaseMachine machine = new AutoPurchaseMachine();
        return machine.purchaseLottos(purchaseAmount);
    }

    private void outputLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size())
                .append("개를 구매했습니다.")
                .append("\n")
                .append(LottoService.getStringOfLottos(lottos));
        view.output(sb.toString());
    }
}
