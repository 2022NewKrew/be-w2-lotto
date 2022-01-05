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
        return getUserInputInt(MESSAGE_QUERY_MANUAL_LOTTO_COUNT);
    }

    public List<List<Integer>> queryManualLottoNumbers(int lottoCount) throws IOException {
        List<List<Integer>> manualLottoTickets = new ArrayList<>();
        while(lottoCount-- > 0) {
            String[] inputArray = getUserInputString(MESSAGE_QUERY_MANUAL_LOTTO_NUMBERS).split(",");
            manualLottoTickets.add(
                    Arrays.stream(inputArray).map(Integer::parseInt).collect(Collectors.toList())
            );
        }
        return manualLottoTickets;
    }

    public List<Integer> queryWinningLotto() throws IOException {
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


}
