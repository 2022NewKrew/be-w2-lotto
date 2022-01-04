package com.kakao.validation;

import com.kakao.domain.WinningLotto;

import java.util.*;

public class CheckGameInput {

    private static final int LOTTO_NUM_CNT = 6;

    public List<Integer> checkLottoInput(String[] input) {
        checkNumCnt(input);
        try {
            List<Integer> lotto = mapToInt(input);
            checkNumOverlap(lotto);
            Collections.sort(lotto);
            return lotto;
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    private void checkNumCnt(String[] input) {
        if (input.length != LOTTO_NUM_CNT) {
            System.out.printf("%d개의 번호를 입력해 주세요.\n", LOTTO_NUM_CNT);
            throw new RuntimeException();
        }
    }

    private List<Integer> mapToInt(String[] input) {
        List<Integer> lotto = new ArrayList<>();
        for (String num : input) {
            int intNum = Integer.parseInt(num.trim());
            checkNumValidation(intNum);
            lotto.add(intNum);
        }
        return lotto;
    }

    public void checkNumValidation(int num) {
        if (num < 1 || num > 45) {
            System.out.println("1 ~ 45 사이의 번호를 입력해 주세요.");
            throw new RuntimeException();
        }
    }

    private void checkNumOverlap(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if (lottoSet.size() != LOTTO_NUM_CNT) {
            System.out.println("중복된 번호가 존재합니다.");
            throw new RuntimeException();
        }
    }

    public void checkLottoCnt(int totalLottoCnt, int lottoCnt) {
        if (totalLottoCnt < lottoCnt) {
            System.out.printf("최대 %d개를 구입하실 수 있습니다.\n", totalLottoCnt);
            throw new RuntimeException();
        }
    }

    public void checkBonusNum(List<Integer> winningLotto, int bonusNum) {
        if (winningLotto.contains(bonusNum)) {
            System.out.println("이미 존재하는 당첨 번호입니다.");
            throw new RuntimeException();
        }
    }
}
