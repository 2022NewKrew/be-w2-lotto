package com.david.lotto.view;

import com.david.lotto.validation.LottoInputException;
import com.david.lotto.validation.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator = new InputValidator();

    public int inputAmount() {
        boolean isDone = false;
        int amount = 0;
        while (!isDone) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amount = Integer.parseInt(scanner.nextLine());
                inputValidator.validateAmount(amount);
                isDone = true;
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하였습니다.");
            } catch (LottoInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    public List<Integer> inputWinningNumber() {
        List<Integer> lottoNumber = null;
        boolean isDone = false;
        while (!isDone) {
            try {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                lottoNumber = convertToNumberList(scanner.nextLine());
                isDone = true;
            } catch (LottoInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumber;
    }

    public int inputBonusNumber(List<Integer> winningNumber) {
        boolean isDone = false;
        int bonusNumber = 0;
        while (!isDone) {
            try {
                System.out.println("보너스 볼을 입력해 주세요.");
                bonusNumber = Integer.parseInt(scanner.nextLine());
                inputValidator.validateBonusNumber(bonusNumber, winningNumber);
                isDone = true;
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하였습니다.");
            } catch (LottoInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public int inputManualCount(int amount) {
        boolean isDone = false;
        int manualCount = 0;
        while (!isDone) {
            try {
                System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
                manualCount = Integer.parseInt(scanner.nextLine());
                inputValidator.validateManualCount(manualCount, amount);
                isDone = true;
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하였습니다.");
            } catch (LottoInputException e) {
                System.out.println(e.getMessage());
            }
        }

        return manualCount;
    }

    public List<List<Integer>> inputLottoNumber(int manualCount) {
        List<List<Integer>> lottoList = new ArrayList<>();
        int addCount = 0;
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (addCount < manualCount) {
            try {
                lottoList.add(convertToNumberList(scanner.nextLine()));
                addCount++;
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하였습니다.");
                System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            } catch (LottoInputException e) {
                System.out.println(e.getMessage());
                System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            }
        }
        return lottoList;
    }

    private List<Integer> convertToNumberList(String inputString) throws LottoInputException {
        List<Integer> lottoNumber = Arrays.stream(inputString.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        inputValidator.validateLottoNumber(lottoNumber);
        return lottoNumber;
    }
}
