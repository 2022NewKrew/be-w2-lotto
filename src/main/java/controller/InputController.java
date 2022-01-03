package controller;

import exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputController {
    private final Scanner scanner;

    public InputController() {
        scanner = new Scanner(System.in);
    }

    public int getPurchasePrice() {
        try {
            System.out.println("구입금액을 입력해주세요.");

            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw InputException.NumberFormatException();
        }
    }

    public List<Integer> getLottoNumbers() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해주세요.");

            return Arrays.stream(scanner.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw InputException.NumberFormatException();
        }
    }
}
