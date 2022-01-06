package domain.match;

import java.util.ArrayList;

public class WinningLottoNumberDTO {
    private ArrayList<Integer> basicLottoNumbers;
    private ArrayList<Integer> extraBonusLottoNumbers;

    public WinningLottoNumberDTO(ArrayList<Integer> basicLottoNumbers, ArrayList<Integer> extraBonusLottoNumbers) {
        this.basicLottoNumbers = basicLottoNumbers;
        this.extraBonusLottoNumbers = extraBonusLottoNumbers;
    }

    public ArrayList<Integer> getBasicLottoNumbers() {
        return basicLottoNumbers;
    }

    public ArrayList<Integer> getExtraBonusLottoNumbers() {
        return extraBonusLottoNumbers;
    }
}
