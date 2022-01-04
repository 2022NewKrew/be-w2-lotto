package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputInfos {
    private final String BUYING_REQUEST_MESSEGE = "구입금액을 입력해 주세요.";
    private final String LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";


    public InputInfos() {}

    Scanner scanner = new Scanner(System.in);

    public int buyingInfo() {   // 몇개의 ticket을 구입할 것인지를 넘겨줌
        System.out.println(BUYING_REQUEST_MESSEGE);
        return scanner.nextInt();
    }

    public List<Integer> inputLastWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBERS);
        scanner.nextLine();
        String inputString = scanner.nextLine();
        String[] splitStrings = inputString.split(", ");
        System.out.println();
        List<Integer> lastWinningNumbers = new ArrayList<>();
        for (String splitedString : splitStrings) {
            lastWinningNumbers.add(Integer.parseInt(splitedString.trim()));
        }
        return lastWinningNumbers;
    }
}