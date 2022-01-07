package view;

import domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA = ",";

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<List<LottoNumber>> getManualLottoNumbers(int manualLottoCount) {
        if (manualLottoCount > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        return Stream.generate(InputView::getInputNumbers)
                .limit(manualLottoCount)
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<LottoNumber> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getInputNumbers();
    }

    private static List<LottoNumber> getInputNumbers() {
        String numbers = scanner.next();
        return convertStringNumbersToIntegerList(numbers);
    }

    private static List<LottoNumber> convertStringNumbersToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(COMMA))
                .map(number -> LottoNumber.of(Integer.parseInt(number)))
                .collect(Collectors.toUnmodifiableList());
    }

    public static LottoNumber getBounusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return LottoNumber.of(scanner.nextInt());
    }
}
