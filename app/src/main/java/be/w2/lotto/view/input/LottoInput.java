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
        List<LottoNumber> lottoNumbers = convertInputToListOfNumbersAndSortIt(input);
        return new LastWinningLotto(lottoNumbers, LottoNumber.of(inputForBonus));
    }

    static List<Lotto> getManualLottosBy(List<String> inputs) {
        List<Lotto> lottos = new ArrayList<>();
        for (String input : inputs) {
            List<LottoNumber> lottoNumbers = convertInputToListOfNumbersAndSortIt(input);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private static List<LottoNumber> convertInputToListOfNumbersAndSortIt(String input) {
        List<LottoNumber> lottoNumbers = convertInputToListOfNumbers(input);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<LottoNumber> convertInputToListOfNumbers(String input) {
        String[] stringsOfNumber = getStringsOfNumberFrom(input);
        List<LottoNumber> numbers = new ArrayList<>(stringsOfNumber.length);
        for (String stringOfNumber : stringsOfNumber) {
            numbers.add(LottoNumber.of(stringOfNumber));
        }
        Collections.sort(numbers);
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
