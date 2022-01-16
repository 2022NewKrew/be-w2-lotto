package be.w2.lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class RandomTicketGenerator implements TicketGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final LottoNumbers lottoNumbers;

    public RandomTicketGenerator() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = START_NUMBER; i <= END_NUMBER; i++)
            numbers.add(i);
        lottoNumbers = LottoNumbers.getInstanceByIntList(numbers);

    }

    @Override
    public LottoTicket generate() {
        return new LottoTicket(lottoNumbers.getRandomTicketNumbers());
    }
}
