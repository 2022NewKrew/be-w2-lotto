package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_COUNT = 6;
    private static final Random random = new Random(System.currentTimeMillis());

    public static List<Lotto> generate(LottoGameInfo lottoGameInfo) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int currentLotto = 0; currentLotto < lottoGameInfo.getPurchasedQuantity(); currentLotto++) {
            Lotto lotto = createNewLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static Lotto createNewLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_LOTTO_COUNT) {
            addNextLottoNumber(numbers);
        }
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }

    private static void addNextLottoNumber(List<Integer> numbers) {
        int num = random.nextInt(MAX_LOTTO_NUMBER) + 1;
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }

}
