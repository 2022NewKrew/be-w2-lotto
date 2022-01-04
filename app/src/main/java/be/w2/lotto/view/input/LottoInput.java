package be.w2.lotto.view.input;

import be.w2.lotto.exceptions.BadInputException;
import be.w2.lotto.lottos.LastWinningLotto;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.lottos.LottoNumber;
import be.w2.lotto.messages.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class LottoInput {

    private LottoInput() {
    }

    static LastWinningLotto getLastWinningLottoBy(String input, String inputForBonus) {
        List<LottoNumber> numbers = convertStringToListOfNumbers(input);
        Collections.sort(numbers);
        return new LastWinningLotto(numbers, LottoNumber.of(inputForBonus));
    }

    private static List<LottoNumber> convertStringToListOfNumbers(String input) {
        String[] stringsOfNumber = getStringsOfNumberFrom(input);
        List<LottoNumber> numbers = new ArrayList<>(stringsOfNumber.length);
        for (String stringOfNumber : stringsOfNumber) {
            numbers.add(LottoNumber.of(stringOfNumber));
        }
        return numbers;
    }

    private static String[] getStringsOfNumberFrom(String input) {
        String[] stringsOfNumber = input.split(",", Lotto.LENGTH);
        if (stringsOfNumber.length != Lotto.LENGTH) {
            throw new BadInputException(ErrorMessage.BAD_INPUT_FOR_LAST_WINNING_LOTTO);
        }
        return stringsOfNumber;
    }
}
