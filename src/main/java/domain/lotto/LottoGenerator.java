package domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.LottoConst.*;

public class LottoGenerator {

    public static List<Lotto> generateAllLotto(LottoGameInfo lottoGameInfo) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int currentLotto = 0; currentLotto < lottoGameInfo.getAutomaticallyPurchaseQuantity(); currentLotto++) {
            Lotto lotto = createNewLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static Lotto generateOneLotto(List<Integer> inputNumbers) {
        return new Lotto(inputNumbers);
    }

    private static Lotto createNewLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, MAX_LOTTO_COUNT));
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }

    public static WinningLotto generateWinningLotto(List<Integer> inputNumbers, int bonusNumber) {
        return new WinningLotto(inputNumbers, bonusNumber);
    }

}
