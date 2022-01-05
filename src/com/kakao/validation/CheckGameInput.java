package com.kakao.validation;

import java.util.*;

public class CheckGameInput {

    private static final int LOTTO_NUM_CNT = 6;

    public void checkMoney(int input) {
        if (input < 0) {
            throw new RuntimeException();
        }
    }

    public List<Integer> checkLottoInput(String[] input) {
        checkNumberCount(input);
        try {
            List<Integer> lotto = mapToInt(input);
            checkNumberOverlap(lotto);
            Collections.sort(lotto);
            return lotto;
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    private void checkNumberCount(String[] input) {
        if (input.length != LOTTO_NUM_CNT) {
            System.out.printf("%d개의 번호를 입력해 주세요.\n", LOTTO_NUM_CNT);
            throw new RuntimeException();
        }
    }

    private List<Integer> mapToInt(String[] input) {
        List<Integer> lotto = new ArrayList<>();
        for (String num : input) {
            int intNumber = Integer.parseInt(num.trim());
            checkNumberValidation(intNumber);
            lotto.add(intNumber);
        }
        return lotto;
    }

    public void checkNumberValidation(int num) {
        if (num < 1 || num > 45) {
            System.out.println("1 ~ 45 사이의 번호를 입력해 주세요.");
            throw new RuntimeException();
        }
    }

    private void checkNumberOverlap(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if (lottoSet.size() != LOTTO_NUM_CNT) {
            System.out.println("중복된 번호가 존재합니다.");
            throw new RuntimeException();
        }
    }

    public void checkLottoCount(int totalLottoCount, int lottoCount) {
        if (totalLottoCount < lottoCount) {
            System.out.printf("최대 %d개를 구입하실 수 있습니다.\n", totalLottoCount);
            throw new RuntimeException();
        }
    }

    public void checkBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            System.out.println("이미 존재하는 당첨 번호입니다.");
            throw new RuntimeException();
        }
    }
}
