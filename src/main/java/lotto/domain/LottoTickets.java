package lotto.domain;

import lotto.view.InputView;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> tickets = new ArrayList<>();

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    /**
     * 랜덤한 로또 여러장을 추가함
     *
     * @param numOfTickets 랜덤 생성할 로또 수
     */
    public void addRandomLottoTickets(int numOfTickets) {
        assert numOfTickets > 0;

        tickets.addAll(
                IntStream.range(0, numOfTickets)
                        .mapToObj(i -> RandomLottoNumberGenerator.generateRandomLottoNumbers())
                        .map(LottoTicket::new)
                        .collect(Collectors.toList())
        );
    }

    /**
     * 수동 로또를 추가함
     *
     * @param numOfTickets 추가할 로또 수
     * @param inputView    번호 입력받는 뷰
     */
    public void addManualLottoTickets(int numOfTickets, InputView inputView) {
        assert numOfTickets > 0;

        List<Set<Integer>> pickedNumbers = IntStream.rangeClosed(1, numOfTickets)
                .mapToObj(i -> inputView.getWinnerNumbersFromScanner(String.format("%d번째장: ", i)))
                .collect(Collectors.toList());

        tickets.addAll(
                pickedNumbers.stream()
                        .map(LottoTicket::new)
                        .collect(Collectors.toList())
        );
    }

    /**
     * @param winnerNumber 1등 번호
     * @param bonusBall    보너스 숫자
     * @return {@link LottoMatchingResult}
     */
    public LottoMatchingResult getMatchingResult(Set<Integer> winnerNumber, int bonusBall) {
        return new LottoMatchingResult(
                tickets.stream()
                        .map(ticket -> ticket.matchWithWinnerNumber(winnerNumber, bonusBall))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }
}
