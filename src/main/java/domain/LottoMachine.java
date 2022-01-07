package domain;

import exceptions.InvalidPurchaseAmount;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import messages.ErrorMessage;
import utils.RandomMaker;
import validation.Validation;

public class LottoMachine {
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PRISE = 0;
    private static final int MAX_PRISE = 1_000_000_000;
    private static final RandomMaker RANDOM_MAKER = new RandomMaker();

    public LottoMachine() {
    }

    public List<Lotto> buyLottos(long purchaseAmount) {
        Validation.notLessThanLong(purchaseAmount, MIN_PRISE, new InvalidPurchaseAmount(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()));
        Validation.notMoreThanLong(purchaseAmount, MAX_PRISE, new InvalidPurchaseAmount(ErrorMessage.MAX_PURCHASE_AMOUNT.getMessage()));

        long lottoCount = purchaseAmount / LOTTO_PRICE;
        return Stream.generate(this::buy)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private Lotto buy() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < NUMBER_OF_LOTTERY_NUMBERS) {
            numbers.add(RANDOM_MAKER.getRandomNumber(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
        return new Lotto(numbers);
    }
}
