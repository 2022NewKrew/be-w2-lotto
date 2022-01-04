package lotto.view;

import java.util.*;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATOR = ", ";

    private InputView() {}

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int userInput = 0;
        try {
            userInput = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("구입금액은 범위 내의 숫자로 입력해주세요.");
            getPurchaseAmount();
        }
        return userInput;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    public static List<Integer> getWinningNumberList() {
        List<Integer> result = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> userInput = new ArrayList<>(Arrays.asList(sc.nextLine().split(SEPARATOR)));
        for (String stringNumber : userInput) {
            result.add(Integer.parseInt(stringNumber));
        }
        return result;
    }
}
