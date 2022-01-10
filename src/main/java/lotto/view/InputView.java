package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.LottoGame;

public class InputView {

    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_CUSTOM_NUMBER_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_CUSTOM_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        return purchaseAmount;
    }

    public static int inputCustomNumberCount() {
        System.out.println(INPUT_CUSTOM_NUMBER_COUNT_MESSAGE);
        int customNumberCount = Integer.parseInt(scanner.nextLine());
        return customNumberCount;
    }

    public static List<List<Integer>> inputCustomNumber(int customNumberCount) {
        System.out.println(INPUT_CUSTOM_NUMBER_MESSAGE);
        final List<List<Integer>> customLottosNumbers = new ArrayList<>();
        for (int i = 0; i < customNumberCount; i++) {
            List<Integer> lottoNumber = Arrays.stream(scanner.nextLine().split(","))
                .map(number -> Integer.parseInt(number.strip()))
                .collect(Collectors.toList());
            customLottosNumbers.add(lottoNumber);
        }
        return customLottosNumbers;
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumber = Arrays.stream(scanner.nextLine().split(","))
            .map(number -> Integer.parseInt(number.strip()))
            .collect(Collectors.toList());
        return winningNumber;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        return bonusNumber;
    }
}
