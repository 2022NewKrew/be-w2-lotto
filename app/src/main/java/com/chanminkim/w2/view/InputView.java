package com.chanminkim.w2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Integer> getWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
