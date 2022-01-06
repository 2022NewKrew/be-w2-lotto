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
        return Arrays.stream(new Lotto[lottoCount])
                .map(lotto -> new Lotto())
                .collect(Collectors.toList());
    }

    private List<Lotto> buyCustomLottos(List<List<Integer>> customLottoNumberList) {
        return customLottoNumberList.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public WinningLotto setWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public Result setResult(int money, List<Lotto> lottos, WinningLotto winningLotto) {
        return new Result(money, lottos, winningLotto);
    }
}
