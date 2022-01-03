package lotto.domain;

import java.util.List;

public class Round {
    private List<Lotto> lottos;

    public Round(List<Lotto> lottos){
        this.lottos = lottos;
    };
}