package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static Lotto stringToManualLotto(String string) {
        return LottoGenerator.generateManualLotto(getNumbersInput(string));
    }

    public static List<Integer> stringTotWinningNumber(String string) {
        return getNumbersInput(string);
    }

    private static List<Integer> getNumbersInput(String string) {
        List<Integer> result = Arrays.stream(string.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ExceptionCheck.checkValidNumberList(result);
        Collections.sort(result);
        return Collections.unmodifiableList(result);
    }
}
