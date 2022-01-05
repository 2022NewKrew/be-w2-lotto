package step3.domain;

import java.util.List;

public class ManualLottoInnerConfig {

    private final int numberOfManual;
    private final List<List<Integer>> userInputLottoList;

    public ManualLottoInnerConfig(int numberOfManual, List<List<Integer>> userInputLottoList) {
        this.numberOfManual = numberOfManual;
        this.userInputLottoList = userInputLottoList;
    }

    public int getNumberOfManual() {
        return numberOfManual;
    }

    public List<List<Integer>> getUserInputLottoList() {
        return userInputLottoList;
    }
}
