package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private static List<Integer> lottoWinningNumbers;
    private static int bonusNumber;

    private final List<Integer> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = createLottoNumbers();
    }

    public Lotto(String manualInput) {
        this.lottoNumbers = splitLottoNumbers(manualInput);
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> list = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        list = list.subList(0, LOTTO_LENGTH);
        Collections.sort(list);
        return list;
    }

    public static void setLottoWinningNumbers(String lottoInput, int bonusNumber) {
        Lotto.lottoWinningNumbers = splitLottoNumbers(lottoInput);
        validateBonusNumber(bonusNumber);
        Lotto.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_MAX_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 볼 번호는 1~45여야 합니다.");
        }
    }

    private static List<Integer> splitLottoNumbers(String lottoInput) {
        List<Integer> lottoNumbers = Arrays.stream(lottoInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateLottoNumbers(List<Integer> inputLottoNumbers) {
        if (inputLottoNumbers.size() != inputLottoNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 번호를 입력할 수 없습니다.");
        }
        if (inputLottoNumbers.stream().anyMatch((number) -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("복권 번호는 1~45까지여야만 합니다.");
        }
        if (inputLottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("복권 번호는 6개 입력해야 합니다.");
        }
    }

    public void compareLottoNumbers() {
        int correctCount = lottoWinningNumbers.stream().filter(lottoNumbers::contains).toArray().length;
        boolean bonusCorrect = lottoNumbers.contains(bonusNumber);

        Rank.addRankCount(correctCount, bonusCorrect);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
