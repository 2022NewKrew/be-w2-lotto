package lotto.domain;

import lotto.exception.InvaildValueRangeException;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator(int inputMoney, List<List<Integer>> manualLottosNumbers){
        int totalCount = checkInputMoney(inputMoney)/ Util.LOTTO_PRICE;
        checkTotalCountWithManualCount(totalCount, manualLottosNumbers.size());
        this.lottos = generate(totalCount, manualLottosNumbers);
    }

    private int checkInputMoney(int inputMoney) throws InvaildValueRangeException {
        if(inputMoney<1000){
            throw new InvaildValueRangeException("최소 구매 금액보다 입력 금액이 작습니다.");
        }
        return inputMoney;
    }

    private void checkTotalCountWithManualCount(int totalCount, int manualCount) throws InvaildValueRangeException{
        if(manualCount<0){
            throw new InvaildValueRangeException("수동입력 로또 개수의 값이 음수입니다.");
        }
        if(manualCount>totalCount){
            throw new InvaildValueRangeException("로또 구매 가능 개수보다 수동입력 로또 개수가 더 큽니다.");
        }
    }

    private List<Lotto> generate(int totalCount, List<List<Integer>> manualLottosNumbers){
        List<Lotto> lottos = new ArrayList<>();
        for(List<Integer> manualLottoNumbers : manualLottosNumbers){
            lottos.add(new Lotto(manualLottoNumbers));
        }
        for(int i=0; i<totalCount-manualLottosNumbers.size(); i++){
            lottos.add(new Lotto(Util.generateLottoRandomNumbers()));
        }
        return lottos;
    }

    public List<Lotto> generate(){
        return lottos;
    }
}
