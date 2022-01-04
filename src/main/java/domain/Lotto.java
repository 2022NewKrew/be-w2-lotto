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

    private List<Integer> createLottoNumbers() {
        List<Integer> list = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        list = list.subList(0, LOTTO_LENGTH);
        Collections.sort(list);
        return list;
    }

    public static void setLottoWinningNumbers(String lottoInput, int bonusNumber) {
        Lotto.lottoWinningNumbers = splitLottoNumbers(lottoInput);
        Lotto.bonusNumber = bonusNumber;
    }

    private static List<Integer> splitLottoNumbers(String lottoInput) {
        return Arrays.stream(lottoInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int compareLottoNumbers() {
        int correctCount = lottoWinningNumbers.stream().filter(lottoNumbers::contains).toArray().length;
        if (correctCount == 6 || (correctCount == 5 && lottoNumbers.contains(bonusNumber))) {
            return correctCount + 1;
        }
        return correctCount;
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

}
