package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTextConvertor {

    public static final String SINGLE_TEXT_SPLIT_DELIMITER = ",";
    public static final String MANUAL_NUMBER_TEXTS_SPLIT_DELIMITER = "\r?\n";

    private LottoTextConvertor() {

    }

    public static List<List<Integer>> convertManualNumberTextsToList(String manualNumberTexts) {
        List<List<Integer>> result = new ArrayList<>();
        if (manualNumberTexts.length() == 0) {
            return result;
        }

        for (String manualNumberText : manualNumberTexts.split(MANUAL_NUMBER_TEXTS_SPLIT_DELIMITER)) {
            result.add(Arrays.stream(manualNumberText.split(SINGLE_TEXT_SPLIT_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        return result;
    }

    public static List<Integer> convertWinningNumberTextToList(String winningNumberText) {
        return Arrays.stream(winningNumberText.split(SINGLE_TEXT_SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
