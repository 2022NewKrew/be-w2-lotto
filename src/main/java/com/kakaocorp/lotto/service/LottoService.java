package com.kakaocorp.lotto.service;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.dto.ResultResponse;

import java.util.*;

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

    public ResultResponse result(List<Integer> winningNumbers, List<Lotto> lottoList) {
        ResultResponse resultResponse = new ResultResponse();

        int[] resultArray = score(winningNumbers, lottoList);
        resultResponse.setRateOfReturn(lottoList.size() * 100 / Arrays.stream(resultArray).sum());
        resultResponse.setResult(resultArray);

        return resultResponse;
    }

    private int[] score(List<Integer> winningNumbers, List<Lotto> lottoList) {
        int[] result = new int[7];

        for (Lotto lotto : lottoList) {
            int num = match(winningNumbers, lotto);
            result[num] += 1;
        }

        return result;
    }

    private int match(List<Integer> winningNumbers, Lotto lotto) {
        Set<Integer> targetA = new HashSet<>(winningNumbers);
        Set<Integer> targetB = new HashSet<>(lotto.getNumbers());
        targetA.retainAll(targetB);
        return targetA.size();
    }
}
