package carrot.ez.entity;

import carrot.ez.lotto.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottosEntity {
    private Long id;
    private final Long money;
    private final List<LottoEntity> lottos;

    public LottosEntity(Long money, List<LottoEntity> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public Map<Rank, Long> checkWinningNumbers(List<Integer> winingNumbers, int bonus) {

        return lottos.stream()
                .map(lottery -> Rank.of(lottery.getNumOfCorrect(winingNumbers), lottery.isCorrectBonus(bonus)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public List<LottoEntity> getLottos() {
        return lottos;
    }
}
