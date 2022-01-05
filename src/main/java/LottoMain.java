import domain.Lotto;
import domain.LottoPaper;
import view.LottoUI;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        // 복권 구매할 금액 입력
        long money = LottoUI.inputMoney();

        // 일부 로또는 수동
        List<List<Integer>> manualNum = LottoUI.inputManualNum();

        // 구매한 복권 번호 랜덤 생성
        LottoPaper lottoPaper = new LottoPaper(money, manualNum);

        // 복권 번호 출력
        LottoUI.outputLotto(lottoPaper.countLotto(), manualNum.size(), lottoPaper.toString());

        // 당첨 번호 입력
        Lotto winningNum = new Lotto(LottoUI.inputWinningNum());
        int bonusNum = LottoUI.inputBonusNum();

        // 당첨 결과 및 수익률 출력
        LottoUI.outputWinningResult(lottoPaper.winningResult(winningNum, bonusNum));
        LottoUI.outputWinRate(lottoPaper.winRate());
    }
}
