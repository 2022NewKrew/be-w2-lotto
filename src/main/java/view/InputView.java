package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA = ",";

    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winnigNumbers = scanner.next();

        return Arrays.stream(winnigNumbers.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int getBounus(){
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }
}
