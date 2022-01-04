package com.kakaocorp.lotto.service;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.domain.WinningLotto;
import com.kakaocorp.lotto.dto.ResultResponse;

import java.util.*;
import java.util.stream.IntStream;

public class LottoService {

    private static final List<Integer> lottoNumbers = new ArrayList<>() {{
        for (int i = 1; i < 46; i++) {
            add(i);
        }
    }};

    public List<Lotto> buy(int orderPrice) {
        List<Lotto> lottoList = new ArrayList<>();

        int orderAmount = orderPrice / 1000;
        for (int i = 0; i < orderAmount; i++) {
            Collections.shuffle(lottoNumbers);
            List<Integer> subList = new ArrayList<>(lottoNumbers.subList(0, 6));
            Collections.sort(subList);
            lottoList.add(new Lotto(subList));
        }

        return lottoList;
    }

    public ResultResponse result(WinningLotto winningLotto, List<Lotto> lottoList) {
        ResultResponse resultResponse = new ResultResponse();

        List<Integer> scores = score(winningLotto, lottoList);

        int winningMoney = IntStream.range(0, 7).map(i -> scores.get(i) * ResultResponse.winningMoneyList.get(i)).sum();
        int investMoney = lottoList.size() * 1000;
        resultResponse.setRateOfReturn((winningMoney - investMoney) * 100 / investMoney);

        resultResponse.setResult(scores);

        return resultResponse;
    }

    private List<Integer> score(WinningLotto winningLotto, List<Lotto> lottoList) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(7, 0));

        for (Lotto lotto : lottoList) {
            int num = match(winningLotto, lotto);
            result.set(num, result.get(num) + 1);
        }

        return result;
    }

    private int match(WinningLotto winningLotto, Lotto lotto) {
        Set<Integer> targetA = new HashSet<>(winningLotto.getNumbers());
        Set<Integer> targetB = new HashSet<>(lotto.getNumbers());
        targetA.retainAll(targetB);
        return targetA.size();
    }
}
