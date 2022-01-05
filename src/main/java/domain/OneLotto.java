package domain;

import java.util.List;


import java.util.Collections;

public class OneLotto {
    private List<Integer> lottoList;
    private int numberOfWinnings;

    public void makeOneLotto() {
        lottoList = LottoParameter.randomGenerator.pickRandomNumbers();
        Collections.sort(lottoList);
    }

    public int calculateNumberOfWinnings(List<Integer> prevWinningNumbers) {
        numberOfWinnings = 0;
        for(int prevWinningNumber: prevWinningNumbers) {
            checkPrevNumberIsInCurrentNumbers(prevWinningNumber);
        }
        return numberOfWinnings;
    }

    private void checkPrevNumberIsInCurrentNumbers(int prevWinningNumber) {
        if (lottoList.contains(prevWinningNumber)) {
           numberOfWinnings += 1;
        }
    }

    public List<Integer> getLottoList() {
        return lottoList;
    }

    public int getNumberOfWinnings() {
        return numberOfWinnings;
    }
}
