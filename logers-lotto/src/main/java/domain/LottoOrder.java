package domain;

import factory.LottoFactory;

import java.util.List;
import java.util.stream.Collectors;
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

    public Result getResult(WinningNumber winningNumber){
        Result result = new Result();
        for(Lotto lotto : lottos){
            result.addMatched(winningNumber.getMatchedNumber(lotto));
        }
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(lottos.size())
                .concat("개를 구매했습니다.\n")
                .concat(lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining("\n"))
                );
    }
}
