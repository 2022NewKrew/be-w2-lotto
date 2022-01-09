package domain;

import enums.LottoConstants;
import enums.Prize;
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
    private final Set<LottoNumber> lastWeekWinningNumbers;
    private final LottoNumber bonusNumber;

    public LastWeekLottoResult(Set<Integer> lastWeekWinningNumbers, int bonusNumber) {
        if (lastWeekWinningNumbers == null) {
            throw new IllegalArgumentException();
        }
        Validation.sizeShouldBe(lastWeekWinningNumbers, LottoConstants.NUMBER_OF_LOTTERY_NUMBERS.get(),
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

    public EnumMap<Prize, Integer> winningLottoCount(List<LottoTicket> lottoTicketList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);

        initializeMap(lottoResult);
        for (LottoTicket lottoTicket : lottoTicketList) {
            int matchCount = lottoTicket.matchCount(lastWeekWinningNumbers);
            Prize key = Prize.valueOf(matchCount, lottoTicket.contains(bonusNumber));
            int value = lottoResult.get(Prize.valueOf(matchCount, lottoTicket.contains(bonusNumber))) + 1;

            lottoResult.put(key, value);
        }
        return lottoResult;
    }


}
