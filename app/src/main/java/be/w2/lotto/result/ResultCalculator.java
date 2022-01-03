package be.w2.lotto.result;

import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;

import java.util.List;

public class ResultCalculator {

    public static Result getResultOfGame(List<Lotto> myLottos, LastWinningLotto lastWinningLotto) {
        Result result = new Result();
        for(Lotto myLotto: myLottos) {
            int howManyCorrect = lastWinningLotto.getHowManyCorrect(myLotto);
            result.add(howManyCorrect);
        }
        return result;
    }
}
