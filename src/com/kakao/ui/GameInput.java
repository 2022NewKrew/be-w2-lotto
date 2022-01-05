package com.kakao.ui;

import com.kakao.validation.CheckGameInput;

import java.util.*;

public class GameInput {

    private final CheckGameInput checkGameInput = new CheckGameInput();
    private final Scanner sc = new Scanner(System.in);

    public int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요. (로또는 1장에 1000원 입니다.)");
            int money = Integer.parseInt(sc.nextLine());
            checkGameInput.checkNegativeNumber(money);
            return money;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public List<List<Integer>> inputCustomLottos(int money) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        int totalLottoCnt = money / 1000;
        int customLottoCount = inputCustomLottoCount(totalLottoCnt);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < customLottoCount; i++) {
            lottoNumbersList.add(inputCustomLottoNumbers());
        }
        return lottoNumbersList;
    }

    private int inputCustomLottoCount(int totalLottoCount) {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int customLottoCount = Integer.parseInt(sc.nextLine());
            checkGameInput.checkLottoCount(totalLottoCount, customLottoCount);
            return customLottoCount;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputCustomLottoCount(totalLottoCount);
        }
    }

    private List<Integer> inputCustomLottoNumbers() {
        try {
            String[] input = sc.nextLine().split(",");
            List<Integer> lottoNumbers = mapToInt(input);
            checkGameInput.checkLottoInput(lottoNumbers);
            return lottoNumbers;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputCustomLottoNumbers();
        }
    }

    public List<Integer> inputWinningLotto() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String[] input = sc.nextLine().split(",");
            List<Integer> winningLottoNumbers = mapToInt(input);
            checkGameInput.checkLottoInput(winningLottoNumbers);
            return winningLottoNumbers;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputWinningLotto();
        }
    }

    public int inputBonusNumber(List<Integer> winningLotto) {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            int bonusNumber = Integer.parseInt(sc.nextLine());
            checkGameInput.checkBonusNumber(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }

    private List<Integer> mapToInt(String[] input) {
        List<Integer> list = new ArrayList<>();
        for (String num : input) {
            int intNumber = Integer.parseInt(num.trim());
            checkGameInput.checkNumberValidation(intNumber);
            list.add(intNumber);
        }
        Collections.sort(list);
        return list;
    }
}
