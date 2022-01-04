package domain;

import dto.output.ResultOutputDto;
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

    public ResultOutputDto getResult(WinningNumber winningNumber){
        ResultOutputDto resultOutputDto = new ResultOutputDto();
        for(Lotto lotto : lottos){
            resultOutputDto.addMatched(winningNumber.getMatchedNumber(lotto));
        }
        return resultOutputDto;
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
