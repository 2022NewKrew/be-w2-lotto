package view;

import domain.WinningNumber;
import domain.WinningNumbers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final String WINNING_NUMBERS_SPLIT = ",";

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputMoney() throws IOException {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(br.readLine());
    }

    public static WinningNumbers inputWinningNumbers() throws IOException {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);

        String[] winningNumbersInput = br.readLine().split(WINNING_NUMBERS_SPLIT);
        List<WinningNumber> winningNumbers = new ArrayList<>();
        for (int i = 0; i < WINNING_NUMBERS_SIZE; i++) {
            int winningNumber = Integer.parseInt(winningNumbersInput[i].trim());
            winningNumbers.add(new WinningNumber(winningNumber));
        }

        return new WinningNumbers(winningNumbers);
    }
}
