package domain;

import enums.Prize;
import exceptions.InvalidPurchaseAmount;
import messages.ErrorMessage;
import validation.Validation;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    private final List<Integer> lastWeekWinningNumbers;
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int INITIALIZE_ZERO = 0;

    public LottoResult(List<Integer> lastWeekWinningNumbers) {
        if (lastWeekWinningNumbers == null)
            throw new IllegalArgumentException();
        Validation.lengthShouldBe(lastWeekWinningNumbers, NUMBER_OF_LOTTERY_NUMBERS, new InvalidPurchaseAmount(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        this.lastWeekWinningNumbers = lastWeekWinningNumbers;
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
            int matchCount = lotto.checkMatchCount(lastWeekWinningNumbers);
            lottoResult.put(Prize.valueOf(matchCount), lottoResult.get(Prize.valueOf(matchCount)) + 1);
        }
        return lottoResult;
    }

    public double rateOfReturn(long purchaseAmount) {
        // TODO - 수익률을 계산하는 메소드
        return -64.28;
    }
}
