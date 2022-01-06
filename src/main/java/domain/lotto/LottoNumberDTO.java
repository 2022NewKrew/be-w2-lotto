package domain.lotto;

import java.util.ArrayList;

public class LottoNumberDTO {
    private final ArrayList<Integer> lottoNumbersArrayList;

    public LottoNumberDTO(ArrayList<Integer> lottoNumbersArrayList) {
        this.lottoNumbersArrayList = lottoNumbersArrayList;
    }

    public ArrayList<Integer> getArrayListInteger() {
        return lottoNumbersArrayList;
    }
}
