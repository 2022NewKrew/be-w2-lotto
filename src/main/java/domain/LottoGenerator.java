package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    private static final Random random = new Random(System.currentTimeMillis());

    public static List<Lotto> generate(LottoGameInfo lottoGameInfo) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int currentLotto = 0; currentLotto < lottoGameInfo.getNumOfPurchasedQuantity(); currentLotto++) {
            Lotto lotto = createNewLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static Lotto createNewLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            addNextLottoNumber(numbers);
        }
        numbers.sort(Integer::compareTo);

        return new Lotto(numbers);
    }

    private static void addNextLottoNumber(List<Integer> numbers) {
        int num = random.nextInt(45) + 1;
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }

}
