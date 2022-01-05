package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_OF_LOTTO_NUMBER;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    LottoNumbers() {
        ArrayList<Integer> randomNumList;
        randomNumList = makeRandomNumList();
        lottoNumbers = chooseLottoNumbers(randomNumList);
        sortLottoNumbers();
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

    List<Integer> getLottoNumbers() {
        return lottoNumbers;
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
