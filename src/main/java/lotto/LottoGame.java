package lotto;

import java.util.List;
import lotto.dto.InfoDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int GAME_COST = 1000;

    public LottoGame() {
        final LottoGameController lottoGameController = getLottoGameController();
        final InfoDto infoDto = lottoGameController.info();
        OutputView.printLottoInfo(infoDto);

    }

    private static LottoGameController getLottoGameController() {
        final int purchaseAmount = InputView.inputPurchaseAmount();
        final int customNumberCount = InputView.inputCustomNumberCount();
        final List<List<Integer>> customLottosNumbers = InputView.inputCustomNumber(customNumberCount);
        final List<Integer> winningNumbers = InputView.inputWinningNumber();
        final int bonusNumber = InputView.inputBonusNumber();
        return new LottoGameController(purchaseAmount, winningNumbers, bonusNumber, customLottosNumbers);
    }

    public static int getLottoNumberSize() {
        return LOTTO_NUMBER_SIZE;
    }

    public static int getMinNumber() {
        return MIN_NUMBER;
    }

    public static int getMaxNumber() {
        return MAX_NUMBER;
    }

    public static int getGameCost() {
        return GAME_COST;
    }
}