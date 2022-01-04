package com.yapark97.lottoapplication.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoSet {
    private List<Lotto> lottos;

    public LottoSet(final int lottoSetSize) {
        initLottos(lottoSetSize);
    }

    private void initLottos(final int lottoSetSize) {
        lottos = new ArrayList<>(lottoSetSize);
        for (int i=0; i<lottoSetSize; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numberPool = IntStream.rangeClosed(1, LottoConst.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> picked = numberPool.subList(0, LottoConst.LOTTO_NUMBERS_SIZE);

        Collections.sort(picked);
        return picked;
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
