package bin.jaden.be_w2_lotto.lottoGame;

import bin.jaden.be_w2_lotto.data.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGame extends LottoGame {
    private static List<Integer> allNumbers;

    public AutoLottoGame() {
        Collections.shuffle(allNumbers);
        List<Integer> numbers = new ArrayList<>(allNumbers.subList(0, Constants.NUMBERS_PER_GAME));
        super.setNumbers(numbers);
    }

    public static void initAllNumbers() {
        allNumbers = new ArrayList<>(Constants.MAX_LOTTO_NUMBER);
        for (int i = Constants.MIN_LOTTO_NUMBER; i <= Constants.MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }
    }
}
