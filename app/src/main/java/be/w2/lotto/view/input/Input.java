package be.w2.lotto.view.input;

import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.view.output.Output;

import java.util.Scanner;

public final class Input {

    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static synchronized LastWinningLotto inputLastWinningLotto() {
        String input = inputStringWithMessage(GameMessage.INPUT_LAST_WINNING_NUMBER);
        return LottoInput.getLastWinningLottoBy(input);
    }

    public static synchronized int inputIntWithMessage(String message) {
        Output.output(message);
        return scanner.nextInt();
    }

    public static synchronized String inputStringWithMessage(String message) {
        Output.output(message);
        return scanner.next();
    }
}
