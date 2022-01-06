package bin.jaden.be_w2_lotto.lottoGame;

import bin.jaden.be_w2_lotto.data.Constants;
import bin.jaden.be_w2_lotto.exception.DuplicateNumberException;
import bin.jaden.be_w2_lotto.exception.InvalidArraySizeException;
import bin.jaden.be_w2_lotto.exception.NumberOutOfRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ManualLottoGame extends LottoGame {
    public ManualLottoGame(List<Integer> numbers) {
        if (numbers.size() != Constants.NUMBERS_PER_GAME)
            throw new InvalidArraySizeException(Constants.INVALID_MANUAL_NUMBERS_LENGTH_MESSAGE);
        if (numbers.size() != new TreeSet<>(numbers).size()) {
            throw new DuplicateNumberException(Constants.DUPLICATE_MANUAL_NUMBERS_MESSAGE);
        }
        numbers.forEach(ManualLottoGame::rangeCheck);
        super.setNumbers(numbers);
    }

    public ManualLottoGame(String input) {
        this(Arrays.stream(input.split(Constants.INPUT_MANUAL_NUMBERS_DELIMITER))
                .map(Integer::parseInt).collect(Collectors.toList()));
    }

    private static void rangeCheck(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER)
            throw new NumberOutOfRangeException(Constants.INVALID_MANUAL_NUMBERS_RANGE_MESSAGE);
    }
}
