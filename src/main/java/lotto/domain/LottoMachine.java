package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;

public class LottoMachine {

    private final LottoCandidateNumbers lottoCandidateNumbers;

    public static LottoMachine create() {
        return new LottoMachine();
    }

    private LottoMachine() {
        lottoCandidateNumbers = LottoCandidateNumbers.instance();
    }

    public WinningLotto issueWinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        return WinningLotto.of(lotto, bonusNumber);
    }

    public Lotto issueLottoTicketWithNumbers(List<LottoNumber> numbers) {
        return Lotto.from(numbers);
    }

    public LottoTickets purchaseLottoTickets(int numberOfTickets) {
        return LottoTickets.from(IntStream.range(0, numberOfTickets).boxed()
            .map(x -> lottoCandidateNumbers.generateRandomNumbers())
            .map(Lotto::from)
            .collect(Collectors.toList()));
    }
}
