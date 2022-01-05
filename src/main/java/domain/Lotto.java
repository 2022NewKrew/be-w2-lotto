package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final List<LottoNumber> INIT_LOTTO_NUMBERS =
                            IntStream
                            .rangeClosed(1, 45)
                            .mapToObj(LottoNumber::new)
                            .collect(Collectors.toUnmodifiableList());
    private final List<LottoNumber> number;

    public Lotto() {
        number = generateRandomNumber();
        validationLottoNumbers(number);
    }

    public Lotto(List<String> numbers) {
        number = numbers.stream()
                .map(stringInt -> new LottoNumber(stringInt))
                .collect(Collectors.toList());
        validationLottoNumbers(number);
    }

    private List<LottoNumber> generateRandomNumber() {
        List<LottoNumber> numberForShuffle = new ArrayList<>(INIT_LOTTO_NUMBERS);
        Collections.shuffle(numberForShuffle);
        // 1~45의 숫자를 랜덤순서로 섞는다
        List<LottoNumber> number = numberForShuffle.subList(0, 6);
        // 랜덤 순서의 1~45 중 상위 6개를 뽑는다.
        Collections.sort(number);
        // 랜덤하게 뽑은 로또번호를 정렬한다.
        return number;
    }

    private void validationLottoNumbers(List<LottoNumber> lottoNumberList) {
        if (lottoNumberList.size() != 6) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
        }
        Set<LottoNumber> checkDuplicated = new TreeSet<>(lottoNumberList);
        if (checkDuplicated.size() != 6) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
    }

    public boolean isNumberExist(LottoNumber lottoNumber) {
        return number.contains(lottoNumber);
    }

    public List<LottoNumber> getNumber() {
        return number;
    }

    public int getSameNumber(Lotto other) {
        return (int) number.stream()
                .map(num -> other.isNumberExist(num))
                .filter(numExist -> numExist)
                .count();
    }
}
