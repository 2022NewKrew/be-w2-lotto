package domain.match;

import domain.lotto.LottoNumber;
import domain.lotto.LottoNumberDTO;

import java.util.ArrayList;

public class WinningLottoNumber {

    private ArrayList<Integer> basicLottoNumbers;
    private ArrayList<Integer> extraBonusLottoNumbers;

    public WinningLottoNumber(ArrayList<Integer> basicLottoNumbers, ArrayList<Integer> extraBonusLottoNumbers) {
        this.basicLottoNumbers = basicLottoNumbers;
        this.extraBonusLottoNumbers = extraBonusLottoNumbers;
    }

    public WinningLottoNumber(WinningLottoNumberDTO dto) {
        this(dto.getBasicLottoNumbers(), dto.getExtraBonusLottoNumbers());
    }

    public int calculateRank(LottoNumberDTO dto) {
        return calculateRank(dto.getArrayListInteger());
    }
    public int calculateRank(LottoNumber lottoNumber) {
        return calculateRank(lottoNumber.getLottoNumbers());
    }
    private int calculateRank(ArrayList<Integer> lottoNumbersArrayList) {
        int numOfMatchsInBasicNumbers = matchTwoArrayInteger(basicLottoNumbers, lottoNumbersArrayList);
        int numOfMatchsInExtraNumbers = matchTwoArrayInteger(extraBonusLottoNumbers, lottoNumbersArrayList);
        int numOfMatchTarget = basicLottoNumbers.size();

        // 모든 것이 매치되면 1등
        if (numOfMatchsInBasicNumbers == numOfMatchTarget) {
            return 1;
        }
        // 보너스 까지 포함해서 전부 매치되면 2등
        if (numOfMatchsInBasicNumbers + numOfMatchsInExtraNumbers >= numOfMatchTarget) {
            return 2;
        }

        // 그 외 3등 이하
        return numOfMatchTarget - numOfMatchsInBasicNumbers + 2;
    }
    public ArrayList<Integer> getBasicLottoNumbers(){
        return basicLottoNumbers;
    }

    public ArrayList<Integer> getExtraBonusLottoNumbers() {
        return extraBonusLottoNumbers;
    }

    private int matchTwoArrayInteger(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return (int) list1.stream().filter(list2::contains).count();
    }
}
