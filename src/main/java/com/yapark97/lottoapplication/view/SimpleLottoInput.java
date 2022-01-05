package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.lotto.LottoConst;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleLottoInput implements LottoInput {
    private static final SimpleLottoInput simpleLottoInput = new SimpleLottoInput();
    private static final Scanner sc = new Scanner(System.in);

    // 싱글톤 클래스
    private SimpleLottoInput() {
    }

    public static SimpleLottoInput getInstance() {
        return simpleLottoInput;
    }

    @Override
    public int takeLottoPriceInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return validatePrice(sc.nextLine());
    }

    private int validatePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            return validatePriceValue(price);
        } catch (Exception e) {
            System.err.println("구입금액을 정확히 입력해 주세요.");
            return takeLottoPriceInput();
        }
    }

    private int validatePriceValue(int price) throws InputMismatchException {
        if (price < 1000 || price % LottoConst.LOTTO_PRICE != 0) {
            throw new InputMismatchException("구매 금액 입력 오류");
        }
        System.out.println(price / LottoConst.LOTTO_PRICE + "개를 구매했습니다.");
        return price;
    }

    @Override
    public int takeManualLottoNumInput(int lottoNum) {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return validateManualLottoNum(sc.nextLine(), lottoNum);
    }

    private int validateManualLottoNum(String input, int lottoNum) {
        int manualLottoNum;

        try {
            manualLottoNum = Integer.parseInt(input);
            validateManualLottoNumRange(manualLottoNum, lottoNum);
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
            return manualLottoNum;
        } catch (Exception e) {
            System.out.println("수동 구매 로또 수가 잘못되었습니다.");
            return takeManualLottoNumInput(lottoNum);
        }
    }

    private void validateManualLottoNumRange(int manualLottoNum, int lottoNum) {
        if (manualLottoNum < 0 || manualLottoNum > lottoNum) {
            throw new InputMismatchException("수동 로또 수가 음수이거나 전체 로또 수보다 큼");
        }
    }

    @Override
    public List<Integer> takeWinningNumbersInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return takeLottoNumbersInput();
    }

    @Override
    public List<Integer> takeLottoNumbersInput() {
        return validateLottoNumbers(sc.nextLine());
    }

    private List<Integer> validateLottoNumbers(String input) {
        try {
            return validateLottoNumbersCount(Arrays.stream(input.split(", "))
                    .map(Integer::parseInt)
                    .map(this::validateNumberRange)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            System.err.println("당첨 번호를 정확히 입력하세요.");
            return takeWinningNumbersInput();
        }
    }

    private int validateNumberRange(int number) {
        if (number < 1 || number > LottoConst.MAX_LOTTO_NUMBER) {
            throw new InputMismatchException("번호가 범위를 벗어남");
        }
        return number;
    }

    private List<Integer> validateLottoNumbersCount(List<Integer> winningNumbers) throws InputMismatchException {
        if (winningNumbers.size() != LottoConst.LOTTO_NUMBERS_SIZE) {
            throw new InputMismatchException("당첨 번호 갯수 오류");
        }
        return winningNumbers;
    }

    @Override
    public int takeBonusBallInput() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = sc.nextLine();
        try {
            return validateNumberRange(Integer.parseInt(input));
        } catch (Exception e) {
            System.err.println("보너스 볼을 정확히 입력하세요 (1~" + LottoConst.MAX_LOTTO_NUMBER + ")");
            return takeBonusBallInput();
        }
    }
}
