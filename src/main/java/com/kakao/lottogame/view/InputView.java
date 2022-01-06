package com.kakao.lottogame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return nextInteger();
    }

    public int inputManualLottoNum() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return nextInteger();
    }

    public List<Integer> inputManualLottoNumbers() {
        return extractInteger(nextString());
    }

    public List<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return extractInteger(nextString());
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해주세요.");
        return nextInteger();
    }

    private List<Integer> extractInteger(String line) {
        return Arrays.stream(line.split(DELIMITER))
            .distinct()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private int nextInteger() {
        return Integer.parseInt(scanner.nextLine());
    }

    private String nextString() {
        return removeSpace(scanner.nextLine());
    }

    private String removeSpace(String line) {
        return line.replaceAll(SPACE, BLANK);
    }
}
