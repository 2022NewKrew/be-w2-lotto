package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.dto.InfoDto;

public class LottoGameController {

    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "로또 구매 금액이 모자랍니다.";
    private static final String WINNNING_NUMBER_COUNT_ERROR_MESSAGE = "당첨 번호 갯수가 잘못됐습니다.";
    private static final String CUSTOM_COUNT_ERROR_MESSAGE = "구매가능 로또 수를 초과했습니다.";
    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final Result result;

    public LottoGameController(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber,
        List<List<Integer>> customLottosNumbers) {
        validate(purchaseAmount, winningNumbers, customLottosNumbers.size());
        this.lottos = Lottos.valueOf(purchaseAmount, customLottosNumbers);
        this.winningLotto = WinningLotto.valueOf(winningNumbers, bonusNumber);
        this.result = Result.valueOf(lottos, winningLotto);
    }

    private void validate(int purchaseAmount, List<Integer> winningLottoNumbers, int customNumberCount) {
        if (purchaseAmount < LottoGame.getGameCost()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
        if (winningLottoNumbers.size() != LottoGame.getLottoNumberSize()) {
            throw new IllegalArgumentException(WINNNING_NUMBER_COUNT_ERROR_MESSAGE);
        }
        if (purchaseAmount / LottoGame.getGameCost() < customNumberCount) {
            throw new IllegalArgumentException(CUSTOM_COUNT_ERROR_MESSAGE);
        }
    }

    public InfoDto info() {
        return InfoDto.valueOf(lottos, winningLotto, result);
    }


}
