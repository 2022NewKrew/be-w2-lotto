package be.w2.lotto.result;

import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;

import java.util.List;

public class ResultCalculator {

    public static Result getResultOfGame(List<Lotto> myLottos, LastWinningLotto lastWinningLotto) {
        Result result = new Result();
        for (Lotto myLotto : myLottos) {
            CorrectSpec correctSpec = getCorrectSpec(lastWinningLotto, myLotto);
            result.add(correctSpec);
        }
        return result;
    }

    private static CorrectSpec getCorrectSpec(LastWinningLotto lastWinningLotto, Lotto myLotto) {
        int howManyCorrect = lastWinningLotto.getHowManyCorrect(myLotto);
        boolean isContainBonus = lastWinningLotto.isContainBonus(myLotto);
        return new CorrectSpec(howManyCorrect, isContainBonus);
    }
}
