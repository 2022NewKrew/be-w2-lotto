package view.screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputScreen {

    private static final String MESSAGE_QUERY_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_QUERY_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_QUERY_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_QUERY_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_QUERY_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int queryPurchaseAmount() throws IOException {
        return getUserInputInt(MESSAGE_QUERY_PURCHASE_AMOUNT);
    }

    public int queryManualLottoCount() throws IOException {
        System.out.println();
        return getUserInputInt(MESSAGE_QUERY_MANUAL_LOTTO_COUNT);
    }

    public List<List<Integer>> queryManualLottoNumbers(int lottoCount) throws IOException {
        System.out.println();
        List<String> userInputMultipleLine = getUserInputMultipleLine(MESSAGE_QUERY_MANUAL_LOTTO_NUMBERS, lottoCount);
        return userInputMultipleLine.stream()
                .map(line -> line.split(","))
                .map(inner -> Arrays.stream(inner)
                        .map(ele -> Integer.valueOf(ele))
                        .collect(Collectors.toList())
                ).collect(Collectors.toList());
    }

    public List<Integer> queryWinningLotto() throws IOException {
        System.out.println();
        String[] inputArray = getUserInputString(MESSAGE_QUERY_WINNING_LOTTO).split(",");
        return Arrays.stream(inputArray).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int queryBonusNumber() throws IOException {
        return getUserInputInt(MESSAGE_QUERY_BONUS_NUMBER);
    }

    private int getUserInputInt(String message) throws IOException {
        System.out.println(message);
        return Integer.parseInt(bufferedReader.readLine());
    }

    private String getUserInputString(String message) throws IOException {
        System.out.println(message);
        return bufferedReader.readLine();
    }

    private List<String> getUserInputMultipleLine(String message, int numOfLine) throws IOException {
        List<String> multipleLines = new ArrayList<>();
        System.out.println(message);
        for(int line = 0; line < numOfLine; line++) {
            multipleLines.add(bufferedReader.readLine());
        }
        return multipleLines;
    }
}
