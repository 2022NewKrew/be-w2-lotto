package model.lotto;

import model.lotto.number.LottoNumber;
import utility.NullChecker;
import utility.RandomSeed;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LENGTH_OF_NUMBERS = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS;

    private final List<LottoNumber> lottoNumbers;

    static {
        LOTTO_NUMBERS = getLegalNumbers();
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        checkNumbers(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto getRandomLotto() {
        return new Lotto(generateRandomNumbers());
    }

    public static Lotto getDefinedLotto(List<Integer> definedLottoNumbers) {
        NullChecker.checkNotNull(definedLottoNumbers);

        return new Lotto(definedLottoNumbers.stream().map(LottoNumber::valueOf).collect(Collectors.toList()));
    }

    private static List<LottoNumber> getLegalNumbers() {
        return IntStream
                .rangeClosed(LottoNumber.START_NUMBER, LottoNumber.FINAL_NUMBER)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> targetLottoNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(targetLottoNumbers, RandomSeed.getRandom());
        targetLottoNumbers = new ArrayList<>(targetLottoNumbers.subList(0, 6));
        Collections.sort(targetLottoNumbers);
        return targetLottoNumbers;
    }

    public int contain(Lotto lotto) {
        return (int) lotto
                .getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean contain(LottoNumber targetLottoNumber) {
        return lottoNumbers.contains(targetLottoNumber);
    }

    private void checkNumbers(List<LottoNumber> lottoNumbers) {
        checkNull(lottoNumbers);
        checkNumbersLength(lottoNumbers);
        checkDuplicateNumber(lottoNumbers);
    }

    private void checkNull(List<LottoNumber> lottoNumbers) {
        NullChecker.checkNotNull(lottoNumbers);
    }

    private void checkNumbersLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 부적절합니다!");
        }
    }

    private void checkDuplicateNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> testSet = new HashSet<>(lottoNumbers);
        if (testSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
