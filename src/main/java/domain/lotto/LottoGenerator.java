package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_COUNT = 6;

    public static List<Lotto> generate(LottoGameInfo lottoGameInfo) {
        List<Lotto> lottoList = new ArrayList<>();
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        for (int currentLotto = 0; currentLotto < lottoGameInfo.getPurchasedQuantity(); currentLotto++) {
            Lotto lotto = createNewLotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static Lotto createNewLotto(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        List<Integer> numbers = new ArrayList<>(lottoNumbers.subList(0, MAX_LOTTO_COUNT));
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }

}
