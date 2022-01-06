package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoConstants.*;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    LottoNumbers() {
        ArrayList<Integer> randomNumList = makeRandomNumList();
        lottoNumbers = chooseLottoNumbers(randomNumList);
        sortLottoNumbers();
        checkLottoNumbers();
    }

    LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        sortLottoNumbers();
        checkLottoNumbers();
    }

    private ArrayList<Integer> makeRandomNumList() {
        ArrayList<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < MAX_OF_LOTTO_NUMBER; i++) {
            randomNums.add(i + 1);
        }
        Collections.shuffle(randomNums);
        return randomNums;
    }

    private List<Integer> chooseLottoNumbers(ArrayList<Integer> randomNumList) {
        return randomNumList.subList(0, COUNT_OF_LOTTO_NUMBER);
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

    private void checkLottoNumbers() {
        // checkNumRange();
        checkNumDuplication();
        checkSize();
    }

    public boolean contains(int target) {
        return lottoNumbers.contains(target);
    }

    public int getElByIndex(int index) {
        return lottoNumbers.get(index);
    }

    public int size() {
        return lottoNumbers.size();
    }

    private void checkNumRange(Integer num) throws IllegalArgumentException {
        if (num < MIN_OF_LOTTO_NUMBER || num > MAX_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 범위의 로또 당첨 번호입니다!");
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
        for (Integer lottoNum : lottoNumbers) {
            String newNumStr = Objects.equals(lottoNum, lottoNumbers.get(lottoNumbers.size() - 1)) ?
                    lottoNum + "" : lottoNum + ", ";
            sb.append(newNumStr);
        }
        sb.append("]");
        return sb.toString();
    }
}
