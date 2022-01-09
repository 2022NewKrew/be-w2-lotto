package lotto.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputInformation {

    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_DIRECT_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_DIRECT_TICKET_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Integer inputMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBER_MESSAGE);
        List<Integer> result = new ArrayList<>();
        Arrays.asList(SCANNER.nextLine().replace(" ", "").split(",")).forEach(number -> {
            result.add(Integer.parseInt(number));
        });
        return result;
    }

    public static int inputDirectTicketsCount() {
        System.out.println(INPUT_DIRECT_TICKET_COUNT_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<List<Integer>> inputAllTicketsNumbers(int count) {
        System.out.println(INPUT_DIRECT_TICKET_NUMBERS_MESSAGE);
        List<List<Integer>> allTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            allTickets.add(inputSingleTicketNumbers());
        }
        return allTickets;
    }

    private static List<Integer> inputSingleTicketNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(SCANNER.nextLine().replace(" ", "").split(",")).forEach(inputNumber -> {
            numbers.add(Integer.parseInt(inputNumber));
        });
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static void inputTicketNumbersMessage() {
        System.out.println(INPUT_DIRECT_TICKET_NUMBERS_MESSAGE);
    }

    public static List<Integer> inputTicketNumbers() {
        return inputSingleTicketNumbers();
    }
}
