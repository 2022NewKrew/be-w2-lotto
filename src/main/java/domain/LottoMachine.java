package domain;

import exceptions.InvalidPurchaseAmount;
import messages.ErrorMessage;
import validation.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {
    }

    public static List<Lotto> buySeveralLotto(long purchaseAmount) {
        Validation.notLessThanLong(purchaseAmount, 0, new InvalidPurchaseAmount(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()));
        // TODO - 남은 금액 계산
        long lottoCount = purchaseAmount / LOTTO_PRICE;

        return Stream.generate(LottoMachine::buy)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private static Lotto buy() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        List<Integer> sortedNumbers = numbers.subList(0, NUMBER_OF_LOTTERY_NUMBERS);
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
    }
}
