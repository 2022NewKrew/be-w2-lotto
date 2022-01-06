package domain.match;

import domain.lotto.LottoNumber;

import java.util.ArrayList;

public class LottoRankCalculator {

    private final WinningLottoNumber winningLottoNumber;

    public LottoRankCalculator(WinningLottoNumber winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }

    public LottoRank calculator(LottoNumber lottoNumber) {
        int numOfMatchsInBasicNumbers = matchTwoArrayInteger(winningLottoNumber.getBasicLottoNumbers(), lottoNumber.getLottoNumbers());
        int numOfMatchsInExtraNumbers = matchTwoArrayInteger(winningLottoNumber.getExtraBonusLottoNumbers(), lottoNumber.getLottoNumbers());
        int numOfMatchTarget = lottoNumber.getLottoNumbers().size();

        // 모든 것이 매치되면 1등
        if (numOfMatchsInBasicNumbers == numOfMatchTarget) {
            return LottoRank.FIRST;
        }
        // 보너스 까지 포함해서 전부 매치되면 2등
        if (numOfMatchsInBasicNumbers + numOfMatchsInExtraNumbers >= numOfMatchTarget) {
            return LottoRank.SECOND;
        }

        // 그 외 3등 이하
        int index = numOfMatchTarget-numOfMatchsInBasicNumbers+2;
        if (index > LottoRank.getNumOfRanks()){
            return LottoRank.NONE;
        }
        return LottoRank.values()[numOfMatchTarget-numOfMatchsInBasicNumbers+2];
    }

    private int matchTwoArrayInteger(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return (int) list1.stream().filter(list2::contains).count();
    }

}
