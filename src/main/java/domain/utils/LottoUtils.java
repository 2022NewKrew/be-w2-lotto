package domain.utils;

import constant.Rank;
import dto.LottoResultDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {
    public static List<Integer> splitSixNum(String numbers) {
        String replace = numbers.replace(" ", "");

        return Arrays.stream(replace.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static LottoResultDto getResult(List<List<Integer>> lottoPaper, List<Integer> winNumbers, Integer bonusNumber, int money) {
        LottoResultDto lottoResultDto = new LottoResultDto();
        int match;
        boolean bonus;
        long totalReward = 0;

        for (List<Integer> lottoNumbers : lottoPaper) {
            match = countMatch(lottoNumbers, winNumbers);
            bonus = lottoNumbers.contains(bonusNumber);

            Rank rank = Rank.valueOf(match, bonus);
            if (rank != null) {
                lottoResultDto.increase(rank);
                totalReward += rank.getReward();
            }
        }

        long winRate = (totalReward - money) / money * 100;
        lottoResultDto.setWinRate(winRate);

        return lottoResultDto;
    }

    private static int countMatch(List<Integer> l1, List<Integer> l2) {
        return (int) l1.stream()
                .filter(l2::contains)
                .count();
    }
}
