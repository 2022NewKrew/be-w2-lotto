package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultGenerator {

    public static List<Result> generate(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum){
        List<Result> results = new ArrayList<>();

        for(Rank rank : Rank.values()){
            results.add(new Result(rank));
        }

        lottos.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNum))
                .filter(Objects::nonNull)
                .forEach(rank -> addCount(rank, results));

        return results;
    }

    private static void addCount(Rank rank, List<Result> results){
        for(Result result : results){
            if(result.getRank().equals(rank)){
                result.plusCount();
                return;
            }
        }
    }
}
