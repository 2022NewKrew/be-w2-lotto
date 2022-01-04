package com.yapark97.lottoapplication.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Integer> numberPool = new ArrayList<>(LottoConst.MAX_LOTTO_NUMBER);
        List<Integer> picked;

        for (int i=0; i<LottoConst.MAX_LOTTO_NUMBER; i++) {
            numberPool.add(i + 1); // 1~45로 채우기
        }
        Collections.shuffle(numberPool);
        picked = numberPool.subList(0, LottoConst.LOTTO_NUMBERS_SIZE); // 6개 뽑기
        Collections.sort(picked);
        return picked;
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
