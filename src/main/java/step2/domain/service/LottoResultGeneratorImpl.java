package step2.domain.service;

import step2.domain.Lotto;
import step2.domain.LottoSheetWithId;
import step2.domain.PrizeType;
import step2.domain.WinningLotto;
import step2.dto.LottoResultDto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultGeneratorImpl implements LottoResultGenerator{

    @Override
    public LottoResultDto makeLottoResult(WinningLotto winningLotto, LottoSheetWithId lottoSheetWithId) {
        // Map<당첨 등수, 몇개> 계산
        Map<String, Integer> prizeToCountMap = calcLottoPrizeToCountMap(winningLotto, lottoSheetWithId);

        // 금액 정보가 없어서 계산...(수익률 제공을 위해)
        int purchaseAmount = lottoSheetWithId.getLottoList().size() * LottoSheetIssuer.PRICE;
        return new LottoResultDto(prizeToCountMap, purchaseAmount);
    }

    // Map<당첨 등수, 몇개> 계산
    private Map<String, Integer> calcLottoPrizeToCountMap(WinningLotto winningLotto, LottoSheetWithId lottoSheetWithId){
        Map<String, Integer> prizeToCountMap = Arrays.stream(PrizeType.values())
                .collect(Collectors.toMap(PrizeType::name, t -> {return 0;}));

        lottoSheetWithId.getLottoList().forEach(lotto -> addWinLotto(winningLotto, prizeToCountMap, lotto));
        return prizeToCountMap;
    }

    // Lotto(번호 한 줄(6개))를 확인하고 각 등수에 count + 1
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

    // 5등일 경우 보너스 번호 확인하여 추가
    private void checkBonusNum(WinningLotto winningLotto, Map<String, Integer> prizeToCountMap, Lotto lotto) {
        if (lotto.getNumbers().contains(winningLotto.getBonusNum())){
            prizeToCountMap.put(PrizeType.FIVE_AND_BONUS.name(), prizeToCountMap.get(PrizeType.FIVE_AND_BONUS.name()) + 1);
        } else {
            prizeToCountMap.put(PrizeType.FIVE.name(), prizeToCountMap.get(PrizeType.FIVE.name()) + 1);
        }
    }

    // 로또(6개)와 당첨번호 일치 개수 반환
    private int getSingleResult(Lotto lotto, WinningLotto winningLotto){
        return Math.toIntExact(
                lotto.getNumbers().stream()
                        .filter(num -> winningLotto.getWinningLotto().contains(num))
                        .count()
        );
    }
}
