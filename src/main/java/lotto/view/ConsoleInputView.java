package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleInputView implements InputView {
    private static final String LOTTO_NUMBER_SPLIT_DELIMITER = ", ";

    public int getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return new Scanner(System.in).nextInt();
    }

    public int getManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return new Scanner(System.in).nextInt();
    }

    public List<String[]> getManualLottoNumbers(int manualTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, manualTicketCount)
                .mapToObj(i -> new Scanner(System.in).nextLine().split(LOTTO_NUMBER_SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }

    public String[] getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return new Scanner(System.in).nextLine().split(LOTTO_NUMBER_SPLIT_DELIMITER);
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return new Scanner(System.in).nextInt();
    }
}
