package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int TOTAL_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String SPLIT_DELIMITER = ",";
    private static final String ERROR_INVALID_SIZE = "로또의 숫자는 총 6개입니다.";
    private static final String ERROR_INVALID_NUMBER = "로또의 번호는 1 ~ 45 사이의 숫자를 입력해야합니다.";

    private List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto of() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, TOTAL_SIZE);

        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(String lastWeekNumber) {
        List<Integer> lottoNumbers = Arrays.stream(lastWeekNumber.split(SPLIT_DELIMITER))
                .map(number -> Integer.parseInt(number.replaceAll("\\s", "")))
                .collect(Collectors.toList());

        validateLotto(lottoNumbers);

        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != TOTAL_SIZE) {
            throw new IllegalArgumentException(ERROR_INVALID_SIZE);
        }

        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }

    public int getMatchNumberCount(List<Integer> lastWeekLottoNumbers) {
        return (int) lastWeekLottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
