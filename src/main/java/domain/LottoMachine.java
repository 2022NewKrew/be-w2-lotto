package domain;

import exceptions.InvalidPurchaseAmount;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import messages.ErrorMessage;
import validation.Validation;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PRISE = 0;
    private static final int MAX_PRISE = 1_000_000_000;
    private static final RandomLottoTicketGenerator randomLottoTicketGenerator = new RandomLottoTicketGenerator();


    public LottoMachine() {
    }

    public List<LottoTicket> buyLottos(long purchaseAmount) {
        Validation.notLessThanLong(purchaseAmount, MIN_PRISE,
                () -> new InvalidPurchaseAmount(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()));
        Validation.notMoreThanLong(purchaseAmount, MAX_PRISE,
                () -> new InvalidPurchaseAmount(ErrorMessage.MAX_PURCHASE_AMOUNT.getMessage()));

        long lottoCount = purchaseAmount / LOTTO_PRICE;
        return Stream.generate(() -> randomLottoTicketGenerator.generate(null))
                .limit(lottoCount)
                .collect(Collectors.toList());
    }
}
