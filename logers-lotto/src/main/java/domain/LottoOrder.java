package domain;

import factory.LottoFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoOrder {
    private final List<Lotto> lottos;

    public LottoOrder(int purchaseAmount) {
        int times = purchaseAmount / Lotto.PRICE;
        lottos = Stream
                .generate(LottoFactory::createInstance)
                .limit(times)
                .collect(toList());
    }

    public RewardResult getResult(WinningNumbers winningNumbers){
        RewardResult rewardResult = new RewardResult();
        for(Lotto lotto : lottos){
            rewardResult.addMatched(winningNumbers.getMatchedNumber(lotto));
        }
        return rewardResult;
    }

    public List<List<Integer>> getLottos(){
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(toList());
    }
}
