package com.david.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputCount(int lottoPrice) {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine()) / lottoPrice;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
