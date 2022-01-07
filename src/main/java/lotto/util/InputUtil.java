package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.constant.InputMessage.*;

// 예외처리 추가하기
public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);
    public int inputPrice() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());
        return Integer.parseInt(sc.nextLine());
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(sc.nextLine());
    }
}
