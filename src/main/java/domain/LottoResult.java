package domain;

import enums.Prize;
import exceptions.InvalidBonusNumber;
import exceptions.InvalidLastWeekWinningNumber;
import exceptions.InvalidPurchaseAmount;
import messages.ErrorMessage;
import validation.Validation;

import java.util.*;

public class LottoResult {
    private final Set<Integer> lastWeekWinningNumbers;
    private final int bonusNumber;
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int INITIALIZE_ZERO = 0;

    private void checkLastWeekWinningNumbers(Set<Integer> lastWeekWinningNumbers) {
        if (lastWeekWinningNumbers == null)
            throw new IllegalArgumentException();
        Validation.sizeShouldBe(lastWeekWinningNumbers, NUMBER_OF_LOTTERY_NUMBERS, new InvalidPurchaseAmount(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        lastWeekWinningNumbers.forEach(num -> {
            Validation.notLessThanLong(num, MIN_LOTTO_NUMBER, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
            Validation.notMoreThanLong(num, MAX_LOTTO_NUMBER, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        });
    }

    private void checkBonusNumber(Set<Integer> lastWeekWinningNumbers, int bonusNumber) {
        Validation.notLessThanLong(bonusNumber, MIN_LOTTO_NUMBER, new InvalidBonusNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        Validation.notMoreThanLong(bonusNumber, MAX_LOTTO_NUMBER, new InvalidBonusNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        Validation.notHave(lastWeekWinningNumbers, bonusNumber, new InvalidBonusNumber(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage()));
    }

    public LottoResult(Set<Integer> lastWeekWinningNumbers, int bonusNumber) {
        checkLastWeekWinningNumbers(lastWeekWinningNumbers);
        this.lastWeekWinningNumbers = Collections.unmodifiableSet(lastWeekWinningNumbers);

        checkBonusNumber(lastWeekWinningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void InitializeMap(EnumMap<Prize, Integer> lottoResult) {
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, INITIALIZE_ZERO);
        }
    }

    private void addLottoResult(Lotto lotto, EnumMap<Prize, Integer> lottoResult) {
        int matchCount = lotto.matchCount(lastWeekWinningNumbers);

        if (matchCount == 5) {
            lottoResult.put(Prize.valueOf(matchCount, lotto.hasNumber(bonusNumber)), lottoResult.get(Prize.valueOf(matchCount, lotto.hasNumber(bonusNumber))) + 1);
            return;
        }
        lottoResult.put(Prize.valueOf(matchCount, false), lottoResult.get(Prize.valueOf(matchCount, false)) + 1);
    }

    public EnumMap<Prize, Integer> winningLottoCount(List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);

        InitializeMap(lottoResult);
        for (Lotto lotto : lottoList)
            addLottoResult(lotto, lottoResult);
        return lottoResult;
    }

    public double rateOfReturn(long purchaseAmount, List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = winningLottoCount(lottoList);
        long totalEarn = 0;

        for (Map.Entry<Prize, Integer> entry : lottoResult.entrySet())
            totalEarn += entry.getKey().getMoney() * entry.getValue();

        // (평가금액 - 원금) / 원금 * 100
        return (totalEarn - purchaseAmount) / (double) purchaseAmount * 100.0d;
    }
}
