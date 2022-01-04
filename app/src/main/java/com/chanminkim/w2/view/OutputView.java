package com.chanminkim.w2.view;

import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.LottoNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchasedLottoList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        lottoList.forEach(System.out::println);
        System.out.println();
    }

    public void printWinningStatistics(List<Lotto> lottoList, Lotto winningLotto) {
        Map<Integer, Integer> countMap = initCountMap();
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.countMatchedNumbers(winningLotto);
            countMap.put(matchedCount, countMap.get(matchedCount) + 1);
        }

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchedList(countMap);
        printEarningPercentage(lottoList, countMap);
    }

    private void printEarningPercentage(List<Lotto> lottoList, Map<Integer, Integer> countMap) {
        int lotteryWinnings = calculateLotteryWinnings(countMap);
        int principal = Lotto.LOTTO_PRICE * lottoList.size();
        double earningPercentage = (lotteryWinnings - principal) / (double) principal * 100;
        System.out.printf("총 수익률은 %.2f%% 입니다.%n", earningPercentage);
    }

    private void printMatchedList(Map<Integer, Integer> countMap) {
        System.out.printf("3개 일치 (5000원) - %d개%n", countMap.get(3));
        System.out.printf("4개 일치 (50000원) - %d개%n", countMap.get(4));
        System.out.printf("5개 일치 (1500000원) - %d개%n", countMap.get(5));
        System.out.printf("6개 일치 (2000000000원) - %d개%n", countMap.get(6));
    }

    private int calculateLotteryWinnings(Map<Integer, Integer> countMap) {
        return countMap.get(3) * 5000
                + countMap.get(4) * 50000
                + countMap.get(5) * 1500000
                + countMap.get(6) * 2000000000;
    }

    private Map<Integer, Integer> initCountMap() {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < LottoNumber.LOTTO_NUMBER_RANGE.upperEndpoint(); i++) {
            countMap.put(i, 0);
        }
        return countMap;
    }

}
