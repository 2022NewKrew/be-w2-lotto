package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final String LOTTO_ERROR_MESSAGE = "로또 번호에 오류가 있습니다.";
    private static final String LOTTO_BONUS_ERROR_MESSAGE = "보너스 볼에 오류가 있습니다.";

    private static final List<Integer> lottoCandidateNumbers;

    static {
        lottoCandidateNumbers = IntStream.rangeClosed(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
            .boxed().collect(Collectors.toList());
    }

    public WinningLotto generateWinningLotto(Lotto lotto, int bonusNumber) {
        if (!isValidBonusNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_BONUS_ERROR_MESSAGE);
        }
        return new WinningLotto(lotto, bonusNumber);
    }

    private boolean isValidBonusNumber(Lotto lotto, int bonusNumber) {
        return !lotto.hasNumber(bonusNumber) && isValidNumber(bonusNumber);
    }

    private boolean isValidNumber(int number) {
        return number >= LOTTO_NUMBER_START && number <= LOTTO_NUMBER_END;
    }

    public Lotto generateLottoTicketWithNumbers(List<Integer> numbers) {
        if (!isValidNumbersForLotto(numbers)) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE);
        }
        return new Lotto(numbers);
    }

    private boolean isValidNumbersForLotto(List<Integer> numbers) {
        return isValidNumberRange(numbers) && isValidSize(numbers) && isNoDuplicates(numbers);
    }

    private boolean isValidNumberRange(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(this::isValidNumber);
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    private boolean isNoDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == LOTTO_NUMBER_SIZE;
    }

    public List<Lotto> purchaseLottoTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets).boxed()
            .map(x -> generateRandomNumbers())
            .map(Lotto::new)
            .collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumbers() {
        Collections.shuffle(lottoCandidateNumbers);
        return lottoCandidateNumbers.stream().limit(LOTTO_NUMBER_SIZE)
            .sorted().collect(Collectors.toList());
    }
}
