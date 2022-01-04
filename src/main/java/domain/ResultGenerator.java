package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ResultGenerator {
    private final List<Result> results = new ArrayList<>();

    public ResultGenerator() {
        init();
    }

    private void init(){
        for(Rank rank : Rank.values()){
            results.add(new Result(rank));
        }
    }

    public List<Result> generate(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum){
        lottos.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNum))
                .filter(Objects::nonNull)
                .forEach(this::addCount);

        return Collections.unmodifiableList(results);
    }

    private void addCount(Rank rank){
        for(Result result : results){
            if(result.getRank().equals(rank)){
                result.plusCount();
                return;
            }
        }
    }
}
