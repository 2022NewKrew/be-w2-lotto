package model;

import java.util.*;

public class Lotto {

    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateSixNumbers(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateSixNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("반드시 6개의 숫자가 들어가야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<LottoNumber> numbers) {
        Set<Integer> numberSets = new HashSet<>();
        for (LottoNumber lottoNumber: numbers){
            numberSets.add(lottoNumber.getNumber());
        }

        if (numberSets.size() != 6) {
            throw new IllegalArgumentException("로또에 중복된 번호를 넣을 수 없습니다.");
        }
    }

    public LottoRanks compareLotto(WinningNumber winningNumber) {
        int correctNumberCount = winningNumber.compareLottoNumber(numbers);;
        boolean bonus =winningNumber.compareBonusLottoNumber(numbers);
        return LottoRanks.valueOf(correctNumberCount, bonus);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }
}
