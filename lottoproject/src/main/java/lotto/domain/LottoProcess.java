package lotto.domain;

import lotto.util.Util;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
    public void start(){
        List<Lotto> lottos = generateLottos(View.inputInteger("구입금액을 입력해 주세요."));
        View.printBuyResult(lottos);
        List<Integer> resultNumber = View.inputIntegerArrayList("지난 주 당첨 번호를 입력해 주세요.", ",");
        int bonusNumber = View.inputInteger("보너스 볼을 입력해 주세요.");
        Round round = new Round(lottos, resultNumber, bonusNumber);
        View.printRoundResult(round);
    }

    private List<Lotto> generateLottos(int inputMoney){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<inputMoney/Util.LOTTO_PRICE; i++){
            lottos.add(new Lotto(Util.generateRandomNumbers(Util.LOTTO_NUMBER_COUNT, Util.LOTTO_MAX_NUMBER)));
        }
        return lottos;
    }
}
