import domain.LottoPaper;
import view.LottoUI;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        long money = LottoUI.inputMoney();

        LottoPaper lottoPaper = new LottoPaper(money);

        LottoUI.outputLotto(lottoPaper.countLotto(), lottoPaper.toString());

        List<Integer> winningNum = LottoUI.inputWinningNum();

        LottoUI.outputWinningResult(lottoPaper.winningResult(winningNum), lottoPaper.winRate());
    }
}
