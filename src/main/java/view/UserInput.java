package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        try {
            System.out.println("구입 금액을 입력해 주세요");
            int money = scanner.nextInt();
            isOverZero(money);
            checkInputBuffer();
            return money;
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 구입 금액을 입력해주세요. (양수를 입력해 주세요)");
        }
    }

    public static List<Integer> getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return getLotto();
    }

    public static int getBonusBall() {
        try {
            System.out.println("보너스 볼을 입력해주세요");
            int bonusNumber = scanner.nextInt();
            isOverZero(bonusNumber);
            return bonusNumber;
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 보너스 볼을 입력해주세요. (양수를 입력해 주세요)");
        }
    }

    public static int getNumberOfManualLotto() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int numberOfLottoByManual = scanner.nextInt();
            checkInputBuffer();
            return numberOfLottoByManual;
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 수를 입력해주세요 (양수를 입력해주세요)");
        }
    }

    public static List<List<Integer>> getManualLotto(int numberOfManualLotto) {
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numberOfManualLotto; i++) {
            result.add(getLotto());
        }
        return result;
    }

    private static List<Integer> getLotto() {
        try {
            return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 번호를 입력해주세요. (당첨번호는 정수를 입력해주세요)");
        }
    }

    private static void checkInputBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private static void isOverZero(int number) {
        if (number > 0) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
