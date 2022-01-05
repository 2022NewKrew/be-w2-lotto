package model;

import dto.request.LottoPurchaseDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final List<Integer> drawNumbers;

    public LottoGenerator() {
        int MIN = 1;
        int MAX = 45;

        drawNumbers =
                IntStream.rangeClosed(MIN, MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto generate(LottoPurchaseDTO lottoPurchaseDTO) {
        int PRICE_OF_TICKET = 1000;
        int numberOfLotto = lottoPurchaseDTO.getBudget() / PRICE_OF_TICKET - lottoPurchaseDTO.getNumberOfManualLotto();

        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.addAll(
                lottoPurchaseDTO
                        .getManualLottoTickets()
                        .stream()
                        .map(LottoTicket::new)
                        .collect(Collectors.toList())
        );

        lottoTickets.addAll(
                IntStream.range(0, numberOfLotto)
                        .mapToObj(number -> generateTicket())
                        .collect(Collectors.toList())
        );

        return new Lotto(lottoTickets);
    }

    private LottoTicket generateTicket() throws RuntimeException {
        int NUMBER_OF_LOTTO = 6;

        Collections.shuffle(drawNumbers);
        List<Integer> numbers = new ArrayList<>(drawNumbers.subList(0, NUMBER_OF_LOTTO));
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }
}
