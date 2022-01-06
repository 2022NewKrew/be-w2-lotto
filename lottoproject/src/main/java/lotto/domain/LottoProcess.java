package lotto.domain;

import lotto.view.View;
import java.util.List;

public class LottoProcess {
    public void start(){
        List<Lotto> lottos = buyLottos(View.inputInteger("구입금액을 입력해 주세요."), View.inputInteger("수동으로 구매할 로또 수를 입력해 주세요."));
        View.printBuyResult(lottos);
        List<Integer> resultNumber = View.inputIntegerArrayList("지난 주 당첨 번호를 입력해 주세요.", ",");
        int bonusNumber = View.inputInteger("보너스 볼을 입력해 주세요.");
        Round round = new Round(lottos, resultNumber, bonusNumber);
        View.printRoundResult(round);
    }

    private List<Lotto> buyLottos(int inputMoney, int manualCount){
        List<List<Integer>> manualLottosNumbers = View.inputIntegerArrayLists("수동으로 구매할 번호를 입력해 주세요.", ",", manualCount);
        LottoGenerator lottogeneraor = new LottoGenerator(inputMoney, manualLottosNumbers);
        return lottogeneraor.generate();
    }
}

