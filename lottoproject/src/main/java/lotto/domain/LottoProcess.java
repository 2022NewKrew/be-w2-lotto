package lotto.domain;

import lotto.util.Util;
import lotto.util.Validator;
import lotto.view.View;
import java.util.ArrayList;
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

    private List<Lotto> generateLottosByAuto(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<count; i++){
            lottos.add(new Lotto(Util.generateRandomNumbers(Util.LOTTO_NUMBER_COUNT, Util.LOTTO_MAX_NUMBER)));
        }
        return lottos;
    }

    private List<Lotto> generateLottosByManual(int count){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(View.inputIntegerArrayList("수동으로 구매할 번호를 입력해 주세요.", ",")));
        for(int i=0; i<count-1; i++){
            lottos.add(new Lotto(View.inputIntegerArrayList("", ",")));
        }
        return lottos;
    }

    private List<Lotto> buyLottos(int inputMoney, int manualCount){
        inputMoney = Validator.checkInputMoney(inputMoney);
        int totalCount = inputMoney/Util.LOTTO_PRICE;
        List<Lotto> result = new ArrayList<>();
        result.addAll(generateLottosByManual(manualCount));
        result.addAll(generateLottosByAuto(totalCount-manualCount));
        return result;
    }
}

