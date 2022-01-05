package domain;


import dto.output.ResultOutputDto;
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


    public ResultOutputDto getResult(WinningNumber winningNumber){
        ResultOutputDto resultOutputDto = new ResultOutputDto();
        for(Lotto lotto : lottos){
            resultOutputDto.addMatched(winningNumber.getMatchedNumber(lotto));
        }
        return resultOutputDto;
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }
}
