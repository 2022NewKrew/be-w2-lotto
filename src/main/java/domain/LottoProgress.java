package domain;


import dto.PurchasedLottoDTO;
import dto.WinnigStatisticDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoProgress {

    private List<Integer> prevWinningNumbers;
    private List<OneLotto> totalLotto;
    private List<Integer> countOfTotalWinnings;


    public PurchasedLottoDTO buyingLotto(PurchasedLottoDTO purchasedLottoDTO) {
        totalLotto = new ArrayList<>();
        for(int i=0; i<purchasedLottoDTO.getLottoCount(); i++) {
            OneLotto oneLotto = new OneLotto();
            oneLotto.makeOneLotto();
            totalLotto.add(oneLotto);
        }
        purchasedLottoDTO.setTotalLotto(totalLotto);
        return purchasedLottoDTO;
    }

    public WinnigStatisticDTO calculateWinningStatistic(WinnigStatisticDTO winnigStatisticDTO) {
        int numberOfWinnings = 0;
        initCountOfTotalWinnings();
        prevWinningNumbers = winnigStatisticDTO.getPrevWinningNumbers();
        for(OneLotto oneLotto: totalLotto) {
            numberOfWinnings = oneLotto.calculateNumberOfWinnings(prevWinningNumbers);
            countOfTotalWinnings.set(numberOfWinnings, countOfTotalWinnings.get(numberOfWinnings) + 1);
        }
        winnigStatisticDTO.setCountOfTotalWinnings(countOfTotalWinnings);
        return winnigStatisticDTO;
    }

    private void initCountOfTotalWinnings() {
        countOfTotalWinnings = new ArrayList<>();
        for(int i=0; i<=LottoParameter.numberOfLottoPicks; i++) {
            countOfTotalWinnings.add(0);
        }
    }



}
