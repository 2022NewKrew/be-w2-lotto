package domain;

import enums.LottoConstants;
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

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PRISE = 0;
    private static final int MAX_PRISE = 1_000_000_000;
    private static final RandomMaker RANDOM_MAKER = new RandomMaker();

    public LottoMachine() {
    }

    public List<LottoTicket> buyLottos(long purchaseAmount) {
        Validation.notLessThanLong(purchaseAmount, MIN_PRISE,
                () -> new InvalidPurchaseAmount(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()));
        Validation.notMoreThanLong(purchaseAmount, MAX_PRISE,
                () -> new InvalidPurchaseAmount(ErrorMessage.MAX_PURCHASE_AMOUNT.getMessage()));

        long lottoCount = purchaseAmount / LOTTO_PRICE;
        return Stream.generate(this::buy)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private LottoTicket buy() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < LottoConstants.NUMBER_OF_LOTTERY_NUMBERS.get()) {
            numbers.add(RANDOM_MAKER.getRandomNumber(LottoConstants.MIN_LOTTO_NUMBER.get(),
                    LottoConstants.MAX_LOTTO_NUMBER.get()));
        }
        return new LottoTicket(numbers);
    }
}
