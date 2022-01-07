package domain;

import enums.LottoConstants;
import enums.Prize;
import exceptions.InvalidBonusNumber;
import exceptions.InvalidPurchaseAmount;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import messages.ErrorMessage;
import validation.Validation;

public class LottoResult {

    private static final int INITIALIZE_ZERO = 0;
    private final Set<LottoNumber> lastWeekWinningNumbers;
    private final LottoNumber bonusNumber;

    public LottoResult(Set<Integer> lastWeekWinningNumbers, int bonusNumber) {
        if (lastWeekWinningNumbers == null) {
            throw new IllegalArgumentException();
        }
        Validation.sizeShouldBe(lastWeekWinningNumbers, LottoConstants.NUMBER_OF_LOTTERY_NUMBERS.get(),
                () -> new InvalidPurchaseAmount(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        Validation.notContains(lastWeekWinningNumbers, bonusNumber,
                () -> new InvalidBonusNumber(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage()));

        this.lastWeekWinningNumbers = lastWeekWinningNumbers.stream().map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void InitializeMap(EnumMap<Prize, Integer> lottoResult) {
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, INITIALIZE_ZERO);
        }
    }

    public EnumMap<Prize, Integer> winningLottoCount(List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);

        InitializeMap(lottoResult);
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.matchCount(lastWeekWinningNumbers);
            Prize key = Prize.valueOf(matchCount, lotto.contains(bonusNumber));
            int value = lottoResult.get(Prize.valueOf(matchCount, lotto.contains(bonusNumber))) + 1;

            lottoResult.put(key, value);
        }
        return lottoResult;
    }

    public double rateOfReturn(long purchaseAmount, List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = winningLottoCount(lottoList);
        long totalEarn = 0;

        for (Map.Entry<Prize, Integer> entry : lottoResult.entrySet()) {
            totalEarn += entry.getKey().getMoney() * entry.getValue();
        }

        // (평가금액 - 원금) / 원금 * 100
        return (totalEarn - purchaseAmount) / (double) purchaseAmount * 100.0d;
    }
}
