package be.w2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLottoTicket {
    List<LottoNumber> winningNumbers;

    private WinningLottoTicket(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLottoTicket valueOf(String winningNumbersInput) {
        List<String> parsedWinningNumbers = parseWinningLottoTicket(winningNumbersInput);
        validateNumbers(parsedWinningNumbers);

        List<LottoNumber> winningNumbers = parsedWinningNumbers
                .stream().map(Integer::parseInt)
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return new WinningLottoTicket(winningNumbers);
    }

    private static void validateNumbers(List<String> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자가 필요합니다.");
        }
    }

    private static List<String> parseWinningLottoTicket(String winningNumbersInput) {
        return Stream.of(winningNumbersInput.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.winningNumbers;
    }

    private static final String DELIMITER = ",";

    private static final int LOTTO_SIZE = 6;
}
