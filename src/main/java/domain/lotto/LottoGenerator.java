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

        for (int currentLotto = 0; currentLotto < lottoGameInfo.getPurchasedQuantity(); currentLotto++) {
            Lotto lotto = createNewLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static Lotto generateOneLotto(String[] inputNumbers) {
        List<Integer> numbers = Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    private static Lotto createNewLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, MAX_LOTTO_COUNT));
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }

}
