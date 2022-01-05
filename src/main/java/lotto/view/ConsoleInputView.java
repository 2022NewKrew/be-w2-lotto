package lotto.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final String LOTTO_NUMBER_SPLIT_DELIMITER = ", ";

    public int getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return new Scanner(System.in).nextInt();
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
