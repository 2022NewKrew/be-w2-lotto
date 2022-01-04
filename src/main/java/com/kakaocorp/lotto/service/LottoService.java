package com.kakaocorp.lotto.service;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.domain.WinningLotto;
import com.kakaocorp.lotto.dto.ResultResponse;
import com.kakaocorp.lotto.enums.Grade;

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

        int totalWinningMoney = IntStream.range(0, 8).map(i -> scores.get(i) * ResultResponse.winningMoneyList.get(i)).sum();
        int investMoney = lottoList.size() * 1000;

        resultResponse.setRateOfReturn((totalWinningMoney - investMoney) / investMoney * 100);
        resultResponse.setResults(scores);

        return resultResponse;
    }

    private List<Integer> score(WinningLotto winningLotto, List<Lotto> lottoList) {
        // index 0~6에는 index 만큼 일치하는 로또의 갯수가 담겨 있고, index 7에는 5개 일치 + 보너스 볼 일치인 로또의 갯수가 담겨 있다
        List<Integer> results = new ArrayList<>(Collections.nCopies(8, 0));

        for (Lotto lotto : lottoList) {
            int num = match(winningLotto, lotto);
            results.set(num, results.get(num) + 1);

            // Lotto 객체에 grade 기록
            rank(lotto, num);
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
