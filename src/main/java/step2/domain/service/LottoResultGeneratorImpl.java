package step2.domain.service;

import step2.domain.Lotto;
import step2.domain.LottoSheetWithId;
import step2.domain.WinningLotto;
import step2.dto.LottoResultDto;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class LottoResultGeneratorImpl implements LottoResultGenerator{

    @Override
    public LottoResultDto makeLottoResult(WinningLotto winningLotto, LottoSheetWithId lottoSheetWithId) {
        Map<Integer, Long> groupByResult = lottoGroupByResult(winningLotto, lottoSheetWithId);

        Map<Integer, Integer> lottoPrizeToResultMap = lottoPrizeToIntResultMap(groupByResult);

        int purchaseAmount = lottoSheetWithId.getLottoList().size() * LottoSheetIssuer.PRICE;
        return new LottoResultDto(lottoPrizeToResultMap, purchaseAmount);
    }

    private Map<Integer, Long> lottoGroupByResult(WinningLotto winningLotto, LottoSheetWithId lottoSheetWithId){
        return lottoSheetWithId.getLottoList().stream()
                .collect(Collectors.groupingBy(lotto -> getSingleResult(lotto, winningLotto), counting()));
    }

    private Map<Integer, Integer> lottoPrizeToIntResultMap(Map<Integer, Long> groupByResult){
        return groupByResult.entrySet().stream()
                .filter(e -> e.getValue() < 3)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().intValue()));
    }

    private int getSingleResult(Lotto lotto, WinningLotto winningLotto){
        return Math.toIntExact(
                lotto.getNumbers().stream()
                        .filter(num -> winningLotto.getWinningLotto().contains(num))
                        .count()
        );
    }
}
