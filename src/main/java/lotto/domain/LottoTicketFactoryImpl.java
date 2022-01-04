package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactoryImpl implements LottoTicketFactory {
    private static final List<Integer> ALL_NUMBERS = IntStream.range(LottoTicket.MIN_NUMBER, LottoTicket.MAX_NUMBER + 1).boxed().collect(Collectors.toList());

    @Override
    public LottoTicket createRandomLottoTicket() {
        return new LottoTicket(createRandomSortedLottoTicketNumbers());
    }

    @Override
    public List<LottoTicket> createRandomLottoTickets(int numOfTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numOfTickets; i++) {
            lottoTickets.add(createRandomLottoTicket());
        }
        return lottoTickets;
    }

    private List<Integer> createRandomSortedLottoTicketNumbers() {
        Collections.shuffle(ALL_NUMBERS);
        List<Integer> numbers = new ArrayList<>(ALL_NUMBERS.subList(0, LottoTicket.LENGTH_OF_NUMBERS));
        Collections.sort(numbers);
        return numbers;
    }

}
