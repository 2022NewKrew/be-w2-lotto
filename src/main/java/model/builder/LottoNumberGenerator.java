package model.builder;

import constants.LottoRule;
import parameters.LottoLine;
import parameters.UserLottoLines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private final List<Integer> forRandomLotto;
    public LottoNumberGenerator() {
        forRandomLotto = new ArrayList<>();
        for(int i = LottoRule.MIN_LOTTO_NUMBER; i <= LottoRule.MAX_LOTTO_NUMBER; i++){
            forRandomLotto.add(i);
        }
    }

    public void makeLines(UserLottoLines userLottoLines, int amount){
        for(int line = 0; line < amount; line++){
            userLottoLines.addLottoLine(makeLine());
        }

    }

    private LottoLine makeLine(){
        Collections.shuffle(forRandomLotto);
        List<Integer> lottoNumbers = new ArrayList<>(LottoRule.LOTTO_NUMBER_COUNT);
        for(int number = LottoRule.MIN_LOTTO_NUMBER - 1; number < LottoRule.LOTTO_NUMBER_COUNT; number++){
            lottoNumbers.add(forRandomLotto.get(number));
        }
        Collections.sort(lottoNumbers);
        return new LottoLine(lottoNumbers);
    }
}
