package step1.input;

import step1.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputLottoInform {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SPLIT_POINT = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputWinTicketNumbers() {
        List<Integer> lotteryWinNumbers = new ArrayList<>();
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        String inputNumbers = scanner.nextLine();
        for(String number : inputNumbers.replace(" ", "").split(SPLIT_POINT)) {
            lotteryWinNumbers.add(Integer.parseInt(number));
        }

        return lotteryWinNumbers;
    }

    public static Money inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        Money money = new Money(scanner.nextInt());
        scanner.nextLine();
        return money;
    }
}
