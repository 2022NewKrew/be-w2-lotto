package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultGenerator {

    public static List<Result> generate(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum){
        List<Result> results = new ArrayList<>();
        List<Rank> resultRanks = lottos.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNum))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        for(Rank rank : Rank.values()){
            int count = (int)resultRanks.stream().filter(rank::equals).count();
            results.add(new Result(rank, count));
        }

        return results;
    }
}
