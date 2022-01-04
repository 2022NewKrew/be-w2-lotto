package step2.domain.service;

import step2.domain.Lotto;
import step2.domain.LottoSheetWithId;
import step2.domain.PrizeType;
import step2.domain.WinningLotto;
import step2.dto.LottoResultDto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LottoResultGeneratorImpl implements LottoResultGenerator{

    @Override
    public LottoResultDto makeLottoResult(WinningLotto winningLotto, LottoSheetWithId lottoSheetWithId) {

        Map<String, Integer> prizeToCountMap = calcLottoPrizeToIntCountMap(winningLotto, lottoSheetWithId);

        int purchaseAmount = lottoSheetWithId.getLottoList().size() * LottoSheetIssuer.PRICE;
        return new LottoResultDto(prizeToCountMap, purchaseAmount);
    }

    private Map<String, Integer> calcLottoPrizeToIntCountMap(WinningLotto winningLotto, LottoSheetWithId lottoSheetWithId){
        Map<String, Integer> prizeToCountMap = Arrays.stream(PrizeType.values())
                .collect(Collectors.toMap(PrizeType::name, t -> {return 0;}));

        lottoSheetWithId.getLottoList().forEach(lotto -> addWinLotto(winningLotto, prizeToCountMap, lotto));
        return prizeToCountMap;
    }

    private void addWinLotto(WinningLotto winningLotto, Map<String, Integer> prizeToCountMap, Lotto lotto) {
        int matchCount = getSingleResult(lotto, winningLotto);
        if (matchCount < 3) return;

        String prizeType = PrizeType.of(matchCount).name();
        int count = prizeToCountMap.get(prizeType);
        if (matchCount == 3 || matchCount == 4 || matchCount == 6){
            prizeToCountMap.put(prizeType, count+1);
        }
        if (matchCount == 5) checkBonusNum(winningLotto, prizeToCountMap, lotto);
    }

    private void checkBonusNum(WinningLotto winningLotto, Map<String, Integer> prizeToCountMap, Lotto lotto) {
        if (lotto.getNumbers().contains(winningLotto.getBonusNum())){
            prizeToCountMap.put(PrizeType.FIVE_AND_BONUS.name(), prizeToCountMap.get(PrizeType.FIVE_AND_BONUS.name()) + 1);
        } else {
            prizeToCountMap.put(PrizeType.FIVE.name(), prizeToCountMap.get(PrizeType.FIVE.name()) + 1);
        }
    }

    private int getSingleResult(Lotto lotto, WinningLotto winningLotto){
        return Math.toIntExact(
                lotto.getNumbers().stream()
                        .filter(num -> winningLotto.getWinningLotto().contains(num))
                        .count()
        );
    }
}
