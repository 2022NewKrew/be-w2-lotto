package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.LottoConst.*;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int requestQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int currentQuantity = 0; currentQuantity < requestQuantity; currentQuantity++) {
            Lotto lotto = createNewLotto();
            lottos.add(lotto);
        }
        return lottos;
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
