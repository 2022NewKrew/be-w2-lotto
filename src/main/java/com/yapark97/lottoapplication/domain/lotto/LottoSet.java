package com.yapark97.lottoapplication.domain.lotto;

import com.yapark97.lottoapplication.domain.lottocreatestrategy.LottoCreateStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSet {
    private final List<Lotto> lottos = new ArrayList<>();

    public void createLottos(int num, LottoCreateStrategy lottoCreateStrategy) {
        for (int i=0; i<num; i++) {
            lottos.add(lottoCreateStrategy.create());
        }
    }

    public int getLottoSetSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
