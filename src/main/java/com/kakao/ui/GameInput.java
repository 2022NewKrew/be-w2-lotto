package com.kakao.ui;

import com.kakao.validation.CheckGameInput;

import java.util.*;
import java.util.stream.Collectors;

public class GameInput {

    private final CheckGameInput checkGameInput = new CheckGameInput();
    private final Scanner sc = new Scanner(System.in);

    public int inputMoney(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        checkGameInput.checkNegativeNumber(money);
        return money;
    }

    public List<List<Integer>> inputCustomLottos(String[] customLottoNumbersList) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        int customLottoCount = customLottoNumbersList.length;
        if (customLottoCount == 0) { return lottoNumbersList; }
        return Arrays.stream(customLottoNumbersList)
                .map(this::inputCustomLottoNumbers)
                .collect(Collectors.toList());
    }

//    private int inputCustomLottoCount(int totalLottoCount) {
//        try {
//            System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
//            int customLottoCount = Integer.parseInt(sc.nextLine());
//            checkGameInput.checkLottoCount(totalLottoCount, customLottoCount);
//            return customLottoCount;
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//            return inputCustomLottoCount(totalLottoCount);
//        }
//    }

    private List<Integer> inputCustomLottoNumbers(String customLottoNumbers) {
        List<Integer> lottoNumbers = mapToInt(customLottoNumbers.split(","));
        checkGameInput.checkLottoInput(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> inputWinningLotto(String winningLottoNumbersInput) {
        try {
            List<Integer> winningLottoNumbers = mapToInt(winningLottoNumbersInput.split(","));
            checkGameInput.checkLottoInput(winningLottoNumbers);
            return winningLottoNumbers;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public int inputBonusNumber(String bonusNumberInput, List<Integer> winningLotto) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            checkGameInput.checkBonusNumber(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return 0;
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
