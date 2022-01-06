package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.LottoConstants.*;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    LottoNumbers() {
        List<Integer> randomNumList = makeRandomNumList();
        lottoNumbers = chooseLottoNumbers(randomNumList);
        sortLottoNumbers();
        checkLottoNumbers();
    }

    LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        sortLottoNumbers();
        checkLottoNumbers();
    }

    private List<Integer> makeRandomNumList() {
        List<Integer> randomNums = IntStream.rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(randomNums);
        return randomNums;
    }

    private List<Integer> chooseLottoNumbers(List<Integer> randomNumList) {
        return randomNumList.subList(0, COUNT_OF_LOTTO_NUMBER);
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

    public int countIntersectionSize(LottoNumbers ln) {
        return ln.countIntersectionSize(lottoNumbers);
    }

    public int countIntersectionSize(List<Integer> ln) {
        List<Integer> intersection = new ArrayList<>();
        intersection.addAll(lottoNumbers);
        intersection.retainAll(ln);
        return intersection.size();
    }

    private void checkLottoNumbers() {
        checkNumRange();
        checkNumDuplication();
        checkSize();
    }

    public boolean contains(int target) {
        return lottoNumbers.contains(target);
    }

    private void checkNumRange() throws IllegalArgumentException {
        if (lottoNumbers.stream().anyMatch(num -> num < MIN_OF_LOTTO_NUMBER || num > MAX_OF_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("잘못된 범위의 로또 번호입니다!");
        }
    }

    private void checkNumDuplication() throws IllegalArgumentException{
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복이 있는 로또 당첨 번호입니다!");
        }
    }

    private void checkSize() throws IllegalArgumentException{
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 개수의 로또 당첨 번호입니다!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        lottoNumbers.forEach(num -> sb.append(num + ", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
