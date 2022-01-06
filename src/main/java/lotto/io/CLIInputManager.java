package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.*;

public class CLIInputManager implements InputManager {

    public int getPurchaseAmount(String string) {
        return Integer.parseInt(string);
    }

    public int getManualLottoCount(String string) {
        return Integer.parseInt(string);
    }

    public Lotto getManualLotto(String string) {
        return LottoGenerator.generateManualLotto(getNumbersInput(string));
    }

    public List<Integer> getWinningNumber(String string) {
        return getNumbersInput(string);
    }

    public int getBonusNumber(String string) {
        return Integer.parseInt(string);
    }

    private List<Integer> getNumbersInput(String string) {
        List<Integer> result = new ArrayList<>();
        for (String element : string.replace(" ", "").split(",")) {
            result.add(Integer.parseInt(element));
        }
        ExceptionCheck.checkValidNumberList(result);
        Collections.sort(result);
        return Collections.unmodifiableList(result);
    }
}


