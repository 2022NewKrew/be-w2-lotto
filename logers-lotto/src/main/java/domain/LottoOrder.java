package domain;


import dto.ResultDto;
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


    public ResultDto getResult(WinningNumber winningNumber){
        ResultDto resultDto = new ResultDto();
        for(Lotto lotto : lottos){
            resultDto.addMatched(winningNumber.getMatchedNumber(lotto));
        }
        return resultDto;
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }
}
