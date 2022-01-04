package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    List<Integer> lottoNumbers;

    LottoNumbers(int maxOfNum, int cntOfNum) {
        ArrayList<Integer> randomNumList;
        randomNumList = makeRandomNumList(maxOfNum);
        lottoNumbers = chooseLottoNumbers(cntOfNum, randomNumList);
        sortLottoNumbers();
    }

    private ArrayList<Integer> makeRandomNumList(int maxOfNum) {
        ArrayList<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < maxOfNum; i++) {
            randomNums.add(i + 1);
        }
        Collections.shuffle(randomNums);
        return randomNums;
    }

    private List<Integer> chooseLottoNumbers(int cntOfNum, ArrayList<Integer> randomNumList) {
        return randomNumList.subList(0, cntOfNum);
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
