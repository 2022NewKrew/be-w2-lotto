package lotto.service;

import lotto.domain.Constants;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoTicketFactory {

    public static final String NUMBERS_PATTERN = "((\\d{1,2} *, *){5}(\\d{1,2}) *)";
    public static final String DELIMITER = "\\s*,\\s*";
    private static final Random random = new Random();

    public static LottoTicket createAutoLottoTicket() {
        return new LottoTicket(randomLottoNumbers());
    }

    private static List<Integer> randomLottoNumbers() {
        return random.ints(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER_BOUND)
                .distinct()
                .limit(Constants.LOTTO_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public static LottoTicket createManualLottoTicket(String manualNumber) {
        manualNumber = manualNumber.trim();
        validateStringNumbers(manualNumber);

        String[] manualLottoNumbers = manualNumber.split(DELIMITER);

        return new LottoTicket(Arrays.stream(manualLottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private static void validateStringNumbers(String stringNumbers) {
        if (!stringNumbers.matches(NUMBERS_PATTERN)) {
            throw new IllegalArgumentException("숫자 6개만 입력해주세요.");
        }
    }
}
