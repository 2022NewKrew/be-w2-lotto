package com.kakao.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {

    public List<Lotto> buyLottos(int money, List<List<Integer>> customLottoNumbersList) {
        List<Lotto> lottos = new ArrayList<>();
        int totalLottoCount = money / 1000;
        int autoLottoCount = totalLottoCount - customLottoNumbersList.size();
        lottos.addAll(buyCustomLottos(customLottoNumbersList));
        lottos.addAll(buyAutoLottos(autoLottoCount));
        return lottos;
    }

    private List<Lotto> buyAutoLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private List<Lotto> buyCustomLottos(List<List<Integer>> customLottoNumberList) {
        return customLottoNumberList.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public WinningLotto setWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }
}
