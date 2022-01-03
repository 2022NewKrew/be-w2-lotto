package view;

import dto.LottoDTO;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {
    static private final Scanner scanner = new Scanner(System.in);

    static public int getMoney() {
        try {
            System.out.println("구입 금액을 입력해 주세요");
//            if (userInput % Lotto.LOTTO_PRICE != 0) {
//                throw new IllegalArgumentException("[ERROR] 올바른 구입 금액을 입력해주세요. (1000의 배수)");
//            } -- to Service
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 구입 금액을 입력해주세요. (정수를 입력해 주세요)");

        }
    }

    static public List<Integer> getWinningLotto() {
        try {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("지난 주 당첨 번호를 입력해 주세요");
            return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 당첨번호를 입력해주세요. (당첨번호는 정수를 입력해주세요)");
        }
    }

    static public int getBonusNumber(LottoDTO winningLottoDto) {
        try {
            System.out.println("보너스 볼을 입력해 주세요");
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 구입 금액을 입력해주세요. (정수를 입력해 주세요)");
        }

    }
}
