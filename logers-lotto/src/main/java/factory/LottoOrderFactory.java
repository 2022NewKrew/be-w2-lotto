package factory;

import domain.Lotto;
import domain.LottoOrder;
import util.RandomUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoOrderFactory {
    private static LottoOrder instance = null;

    public static Optional<LottoOrder> getInstance(){
        return Optional.of(instance);
    }

    public static Optional<LottoOrder> getInstance(int purchaseAmount){
        if(instance != null){
            return Optional.empty();
        }

        instance = createLottoOrder(purchaseAmount);
        return Optional.of(instance);
    }

    private static LottoOrder createLottoOrder(int purchaseAmount){
        int count = purchaseAmount / Lotto.PRICE;

        List<List<Integer>> numberLists = Stream
                .generate(RandomUtil::createRandomNumbers)
                .limit(count)
                .collect(toList());

        return new LottoOrder(purchaseAmount, numberLists);
    }
}
