package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = Long.parseLong(scanner.nextLine());
        System.out.println();
        return money;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumber();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBallNumber = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return bonusBallNumber;
    }

    public static int inputSelfLottoSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int selfLottoSize = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return selfLottoSize;
    }

    public static List<List<Integer>> inputSelfLottoNumbers(int count) {
        List<List<Integer>> selfLottoNumbers = new ArrayList<>();
        if (count <= 0) {
            return selfLottoNumbers;
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            selfLottoNumbers.add(inputLottoNumber());
        }
        System.out.println();
        return selfLottoNumbers;
    }

    public static List<Integer> inputLottoNumber() {
        String[] values = scanner.nextLine().split(",");
        return Arrays.stream(values)
            .map(value -> Integer.parseInt(value.trim()))
            .collect(Collectors.toList());
    }
}
