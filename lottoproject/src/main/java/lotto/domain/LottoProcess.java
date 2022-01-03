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
        Round round = new Round(lottos, resultNumber);
        View.printRoundResult(round.findResultMap());
    }

    private List<Lotto> generateLottos(int inputMoney){
        List<Lotto> lottos = new ArrayList<Lotto>();
        for(int i=0; i<inputMoney/1000; i++){
            lottos.add(new Lotto(Util.generateRandomNumbers(6, 45)));
        }
        return lottos;
    }
}
