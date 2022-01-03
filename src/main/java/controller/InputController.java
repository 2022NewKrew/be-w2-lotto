package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputController {
    private final Scanner scanner;

    public InputController() {
        scanner = new Scanner(System.in);
    }

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        return Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
