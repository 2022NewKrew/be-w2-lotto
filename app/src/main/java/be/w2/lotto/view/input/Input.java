package be.w2.lotto.view.input;

import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.messages.GameMessage;
import be.w2.lotto.view.output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Input {

    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static synchronized List<Lotto> inputManualLottoNumbers(int numOfManual) {
        List<String> inputs = inputStringsWithMessage(GameMessage.INPUT_MANUAL_NUMBER, numOfManual);
        return LottoInput.getManualLottosBy(inputs);
    }

    public static synchronized LastWinningLotto inputLastWinningLotto() {
        String input = inputStringWithMessage(GameMessage.INPUT_LAST_WINNING_NUMBER);
        String inputForBonus = inputStringWithMessage(GameMessage.INPUT_BONUS_NUMBER);
        return LottoInput.getLastWinningLottoBy(input, inputForBonus);
    }

    public static synchronized List<String> inputStringsWithMessage(String message, int times) {
        Output.output(message);
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            inputs.add(scanner.next());
        }
        return inputs;
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
