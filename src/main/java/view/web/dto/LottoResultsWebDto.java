package view.web.dto;

import constant.Message;
import domain.Lotto;
import domain.LottoResult;
import domain.LottoResults;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;


public class LottoResultsWebDto {

    private final String message;
    private final long totalRateOfReturn;

    public LottoResultsWebDto(LottoResults lottoResults, Lotto lotto) {
        this.message = Arrays.stream(LottoResult.values())
                .sorted(comparingLong(LottoResult::getPrizeMoney))
                .map(lottoResult -> {
                    if (lottoResult.isNeedMatchedBonusNumber()) {
                        return String.format(Message.MATCHING_BONUS_NUMBER, lottoResult.getNumberOfMatchedNumber(),
                                lottoResult.getPrizeMoney(), lottoResults.getCountBy(lottoResult));
                    }

                    return String.format(Message.MATCHING, lottoResult.getNumberOfMatchedNumber(),
                            lottoResult.getPrizeMoney(), lottoResults.getCountBy(lottoResult));
                })
                .collect(Collectors.joining("\n"));

        this.totalRateOfReturn = ((lottoResults.getEarnedMoney() - lotto.getPrice()) / lotto.getPrice()) * 100;
    }

    public String getMessage() {
        return message;
    }

    public long getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}