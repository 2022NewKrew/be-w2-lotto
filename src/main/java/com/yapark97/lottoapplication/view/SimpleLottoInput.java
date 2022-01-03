package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.LottoConst;

import java.util.Arrays;
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
    public int takeLottoSetNumInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return validatePrice(sc.nextLine());
    }

    private int validatePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            System.out.println(price / LottoConst.LOTTO_PRICE + "개를 구매했습니다.");
            return validatePriceValue(price);
        } catch (Exception e) {
            System.err.println("구입금액을 정확히 입력해 주세요.");
            return takeLottoSetNumInput();
        }
    }

    private int validatePriceValue(int price) throws Exception {
        if (price < 1000 || price % LottoConst.LOTTO_PRICE != 0) {
            throw new Exception("구매 금액 입력 오류");
        }
        return price / LottoConst.LOTTO_PRICE;
    }

    @Override
    public List<Integer> takeWinningNumbersInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return validateWinningNumbers(sc.nextLine());
    }

    private List<Integer> validateWinningNumbers(String input) {
        try {
            return validateWinningNumbersCount(Arrays.stream(input.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            System.err.println("당첨 번호를 정확히 입력하세요.");
            return takeWinningNumbersInput();
        }
    }

    private List<Integer> validateWinningNumbersCount(List<Integer> winningNumbers) throws Exception {
        if (winningNumbers.size() != LottoConst.LOTTO_NUMBERS_SIZE) {
            throw new Exception("당첨 번호 갯수 오류");
        }
        return winningNumbers;
    }
}
