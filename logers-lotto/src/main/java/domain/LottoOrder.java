package domain;

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

    private void validate(int purchaseAmount) {
        if(purchaseAmount % Lotto.PRICE != 0){
            throw new IllegalArgumentException(
                    "로또 가격의 단위는 ".concat(String.valueOf(Lotto.PRICE)).concat("입니다."));
        }

        if(purchaseAmount <= 0){
            throw new IllegalArgumentException("구매 금액은 양수로 적어주세요.");
        }
    }

    public RewardResult getResult(WinningNumbers winningNumbers){
        RewardResult rewardResult = new RewardResult();
        for(Lotto lotto : lottos){
            rewardResult.addMatched(winningNumbers.matching(lotto.getNumbers()));
        }
        return rewardResult;
    }

    public List<List<Integer>> getLottos(){
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(toList());
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }
}
