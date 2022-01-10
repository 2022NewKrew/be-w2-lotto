package domain;

import exceptions.InvalidBonusNumber;
import exceptions.InvalidLastWeekWinningNumber;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import messages.ErrorMessage;
import validation.Validation;

public class LastWeekLottoResult {

    private static final int INITIALIZE_ZERO = 0;
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private final Set<LottoNumber> lastWeekWinningNumbers;
    private final LottoNumber bonusNumber;

    public LastWeekLottoResult(Set<Integer> lastWeekWinningNumbers, int bonusNumber) {
        if (lastWeekWinningNumbers == null) {
            throw new IllegalArgumentException();
        }
        Validation.sizeShouldBe(lastWeekWinningNumbers, NUMBER_OF_LOTTERY_NUMBERS,
                () -> new InvalidLastWeekWinningNumber(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        Validation.notContains(lastWeekWinningNumbers, bonusNumber,
                () -> new InvalidBonusNumber(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage()));

        this.lastWeekWinningNumbers = lastWeekWinningNumbers.stream().map(LottoNumber::from)
                .collect(Collectors.toUnmodifiableSet());
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    private void initializeMap(EnumMap<Prize, Integer> lottoResult) {
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, INITIALIZE_ZERO);
        }
    }

    public EnumMap<Prize, Integer> winningLottoCount(LottoTickets lottoTicketList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);

        initializeMap(lottoResult);
        List<LottoTicket> totalTickets = lottoTicketList.totalTickets();
        for (LottoTicket lottoTicket : totalTickets) {
            int matchCount = lottoTicket.matchCount(lastWeekWinningNumbers);

            Prize prize = Prize.valueOf(matchCount, lottoTicket.contains(bonusNumber));
            lottoResult.compute(prize, (key, val) -> (val == null) ? 1 : val + 1);
        }
        return lottoResult;
    }


}
