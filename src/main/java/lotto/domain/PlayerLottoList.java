package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerLottoList {

    private static final int LOTTO_NUMBER_COUNT_MIN = 3;
    private static final int LOTTO_NUMBER_COUNT_MAX = 6;

    private final List<Lotto> lottoList = new ArrayList<>();

    public void purchaseLotto() {
        lottoList.add(new Lotto());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public List<LottoResult> getLottoResults(List<Integer> winningNumbers){
        List<LottoResult> lottoResults = new ArrayList<>();
        Map<Integer, Integer> countMatchingCnt = makeCountingMatchMap(winningNumbers);
        for (int i = LOTTO_NUMBER_COUNT_MIN; i <= LOTTO_NUMBER_COUNT_MAX; i++) {
            lottoResults.add(new LottoResult(i, countMatchingCnt.getOrDefault(i, 0)));
        }
        return lottoResults;
    }

    private HashMap<Integer, Integer> makeCountingMatchMap(List<Integer> winningNumbers){
        HashMap<Integer, Integer> countMatchingCnt = new HashMap<>();
        for(Lotto lotto : lottoList){
            int matchingCnt = compareMatchingCnt(lotto.getNumbers(), winningNumbers);
            countMatchingCnt.put(matchingCnt, countMatchingCnt.getOrDefault(matchingCnt, 0) + 1);
        }
        return countMatchingCnt;
    }

    private int compareMatchingCnt (List<Integer> fromList, List<Integer> toList){
        Set<Integer> set = Stream.concat(fromList.stream(), toList.stream()).collect(Collectors.toSet());
        return LOTTO_NUMBER_COUNT_MAX*2 - set.size();
    }
}
