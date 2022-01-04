package domain;

import utils.RandomMaker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private  static final RandomMaker randomMaker = new RandomMaker();
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {
    }

    public static List<Lotto> buySeveralLotto(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        return Stream.generate(LottoMachine::buy)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private static Lotto buy() {
        List<Integer> numbers = Stream.generate(() -> randomMaker.getRandomNumber(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER))
                .limit(NUMBER_OF_LOTTERY_NUMBERS)
                .collect(Collectors.toList());
        // TODO - 중복 검증 필요
        return new Lotto(numbers);
    }
}
