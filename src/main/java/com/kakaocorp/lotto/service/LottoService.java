package com.kakaocorp.lotto.service;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.domain.WinningLotto;
import com.kakaocorp.lotto.dto.BuyLottoDto;
import com.kakaocorp.lotto.dto.ResultResponse;
import com.kakaocorp.lotto.enums.Grade;

import java.util.*;

public class LottoService {

    private static final List<Integer> lottoNumbers = new ArrayList<>() {{
        for (int i = 1; i < 46; i++) {
            add(i);
        }
    }};

    public BuyLottoDto buy(int orderPrice, List<Lotto> lottoList) {
        int orderAmount = orderPrice / 1000;
        final int orderManualNumber = lottoList.size();
        for (int i = 0; i < orderAmount-orderManualNumber; i++) {
            Collections.shuffle(lottoNumbers);
            List<Integer> subList = new ArrayList<>(lottoNumbers.subList(0, 6));
            Collections.sort(subList);
            lottoList.add(new Lotto(subList));
        }

        return new BuyLottoDto(lottoList, orderManualNumber);
    }

    public ResultResponse result(WinningLotto winningLotto, List<Lotto> lottoList) {
        ResultResponse resultResponse = new ResultResponse();

        Map<Grade, Integer> scores = score(winningLotto, lottoList);

        int totalWinningMoney = scores.entrySet().stream()
                .map(e -> e.getKey().getWinningMoney() * e.getValue())
                .mapToInt(i -> i)
                .sum();
        int investMoney = lottoList.size() * 1000;

        resultResponse.setRateOfReturn((double) (totalWinningMoney - investMoney) / investMoney * 100);
        resultResponse.setResults(scores);
        return resultResponse;
    }

    private Map<Grade, Integer> score(WinningLotto winningLotto, List<Lotto> lottoList) {
        Map<Grade, Integer> results = new HashMap<>();
        Arrays.stream(Grade.values()).forEach(g -> results.put(g, 0));

        for (Lotto lotto : lottoList) {
            int matchIndex = match(winningLotto, lotto);
            // Lotto 객체에 grade 기록
            rank(lotto, matchIndex);

            results.put(lotto.getGrade(), results.getOrDefault(lotto.getGrade(), 0) + 1);
        }

        return results;
    }

    private int match(WinningLotto winningLotto, Lotto lotto) {
        Set<Integer> targetA = new HashSet<>(lotto.getNumbers());
        Set<Integer> targetB = new HashSet<>(winningLotto.getNumbers());
        targetA.retainAll(targetB);
        int matchNumber = targetA.size();

        if (matchNumber == 5 && lotto.getNumbers().contains(winningLotto.getBonusBall())) {
            return 7;
        }

        return matchNumber;
    }

    private void rank(Lotto lotto, int num) {
        switch (num) {
            case 3:
                lotto.rank(Grade.FIFTH);
                return;
            case 4:
                lotto.rank(Grade.FOURTH);
                return;
            case 5:
                lotto.rank(Grade.THIRD);
                return;
            case 7:
                lotto.rank(Grade.SECOND);
                return;
            case 6:
                lotto.rank(Grade.FIRST);
                return;
            default:
                lotto.rank(Grade.NO_GRADE);
        }
    }
}
