package com.yapark97.lottoapplication.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSet {
    // 일급 컬렉션
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

    public Map<Integer, Integer> getStatistic(Lotto winningLotto) {
        Map<Integer, Integer> statistic = new HashMap<>();

        for (Lotto lotto : lottos) {
            int correctNumCount = getCorrectNumCount(winningLotto, lotto);
            statistic.put(correctNumCount, statistic.getOrDefault(correctNumCount, 0) + 1);
        }
        return statistic;
    }

    private int getCorrectNumCount(Lotto winningLotto, Lotto lotto) {
        return (int) winningLotto.getNumbers().stream()
                .map(number -> lotto.getNumbers().contains(number))
                .filter(c -> c)
                .count();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

}
