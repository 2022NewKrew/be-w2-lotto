package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {
    static private final Scanner scanner = new Scanner(System.in);

    static public long getMoney() {
        try {
            System.out.println("구입 금액을 입력해 주세요");
            long money = scanner.nextLong();
            isOverZero(money);
            return money;
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 구입 금액을 입력해주세요. (양수를 입력해 주세요)");

        }
    }

    static public List<Integer> getWinningLotto() {
        try {
            checkInputBuffer();
            System.out.println("지난 주 당첨 번호를 입력해 주세요");
            return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 당첨번호를 입력해주세요. (당첨번호는 정수를 입력해주세요)");
        }
    }

    static private void checkInputBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    static private void isOverZero(long number) {
        if (number > 0) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
