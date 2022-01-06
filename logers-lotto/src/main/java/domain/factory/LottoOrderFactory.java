package domain.factory;

import domain.Lotto;
import domain.LottoOrder;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoOrderFactory {
    private static LottoOrder instance = null;

    public static Optional<LottoOrder> getInstance(){
        return Optional.of(instance);
    }

    public static Optional<LottoOrder> getInstance(int purchasePrise, List<List<Integer>> manualLottoNumberLists){
        if(instance != null){
            return Optional.empty();
        }

        instance = createLottoOrder(purchasePrise, manualLottoNumberLists);
        return Optional.of(instance);
    }

    private static LottoOrder createLottoOrder(int purchasePrise, List<List<Integer>> manualLottoNumberLists){
        List<List<Integer>> numberLists = new ArrayList<>();
        int numOfRandomLotto = purchasePrise / Lotto.PRICE - manualLottoNumberLists.size();

        numberLists.addAll(createRandomLottoNumberLists(numOfRandomLotto));
        numberLists.addAll(manualLottoNumberLists);

        return new LottoOrder(purchasePrise, numberLists);
    }

    private static List<List<Integer>> createRandomLottoNumberLists(int times){
        if(times <= 0){
            return Collections.emptyList();
        }

        return Stream.generate(RandomUtil::createRandomNumbers)
                .limit(times)
                .collect(toList());
    }
}
