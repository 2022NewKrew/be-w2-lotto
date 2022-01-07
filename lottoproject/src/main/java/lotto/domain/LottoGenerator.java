package lotto.domain;

import lotto.exception.InvalidValueRangeException;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGenerator {
    private final Lottos lottos;

    public LottoGenerator(String inputMoney, String manualNumberString){
        List<List<Integer>> manualNumbers = convManualStringToDoubleList(manualNumberString);
        int totalCount = checkInputMoney(Integer.parseInt(inputMoney))/ Util.LOTTO_PRICE;
        checkTotalCountWithManualCount(totalCount, manualNumbers.size());
        this.lottos = generate(totalCount, manualNumbers);
    }

    private int checkInputMoney(int inputMoney){
        if(inputMoney<1000){
            throw new InvalidValueRangeException("최소 구매 금액보다 입력 금액이 작습니다.");
        }
        return inputMoney;
    }

    private void checkTotalCountWithManualCount(int totalCount, int manualCount){
        if(manualCount<0){
            throw new InvalidValueRangeException("수동입력 로또 개수의 값이 음수입니다.");
        }
        if(manualCount>totalCount){
            throw new InvalidValueRangeException("로또 구매 가능 개수보다 수동입력 로또 개수가 더 큽니다.");
        }
    }

    private List<List<Integer>> convManualStringToDoubleList(String manualNumberString){
        if (manualNumberString.equals("")) return new ArrayList<>();
        List<String> manualNumberStrings = Arrays.asList(manualNumberString.split("\r?\n"));
        List<List<Integer>> manualNumbers = new ArrayList<>();
        for(String string : manualNumberStrings){
            manualNumbers.add(Util.convStringToIntegerArraylist(string, ","));
        }
        return manualNumbers;
    }

    private Lottos generate(int totalCount, List<List<Integer>> manualNumbers){
        List<Lotto> lottos = new ArrayList<>();
        for(List<Integer> manualNumber : manualNumbers){
            lottos.add(new Lotto(manualNumber));
        }
        for(int i=0; i<totalCount-manualNumbers.size(); i++){
            lottos.add(new Lotto(Util.generateLottoRandomNumbers()));
        }
        return new Lottos(lottos);
    }

    public Lottos generate(){
        return lottos;
    }
}
