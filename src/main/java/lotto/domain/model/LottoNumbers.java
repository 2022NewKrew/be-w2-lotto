package lotto.domain.model;

import lotto.domain.message.ExceptionMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumbers {
    private static final int TOTAL_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String SPLIT_DELIMITER = ",";
    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private LottoNumbers() { }

    public static List<Integer> getRandomLottoNumbers() {
        Collections.shuffle(lottoNumbers);

        List<Integer> randomLottoNumbers = lottoNumbers.subList(0, TOTAL_SIZE);
        Collections.sort(randomLottoNumbers);

        return randomLottoNumbers;
    }

    public static List<Integer> getWinningLottoNumbers(String winningLottoNumbers) {
        List<Integer> lottoNumbers = Arrays.stream(winningLottoNumbers.split(SPLIT_DELIMITER))
                .map(number -> Integer.parseInt(number.replaceAll("\\s", "")))
                .collect(Collectors.toList());

        validateLottoNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().count() != TOTAL_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_SIZE.getMessage());
        }

        if (lottoNumbers.stream().distinct().count() < TOTAL_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_NUMBER.getMessage());
        }

        if (lottoNumbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }
}
