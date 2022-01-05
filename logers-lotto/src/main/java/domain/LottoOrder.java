package domain;

import factory.LottoFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoOrder {
    private final int purchaseAmount;
    private final List<Lotto> lottos;

    public LottoOrder(int purchaseAmount, List<List<Integer>> numberLists) {
        validate(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
        this.lottos = numberLists.stream()
                .map(Lotto::new)
                .collect(toList());
    }


    public RewardResult getResult(WinningNumbers winningNumbers){
        RewardResult rewardResult = new RewardResult();
        for(Lotto lotto : lottos){
            rewardResult.addMatched(winningNumbers.getMatchedNumber(lotto));
        }
        return rewardResult;
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }
}
