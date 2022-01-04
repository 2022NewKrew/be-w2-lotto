package service;

import domain.lotto.*;
import view.LottoRenderer;

import java.util.List;

public class LottoGameService {

    private List<Lotto> lottoList;

    public void generateLotto(LottoGameInfo lottoGameInfo) {
        lottoList = LottoGenerator.generateAllLotto(lottoGameInfo);
    }

    public void renderLottoList() {
        LottoRenderer.renderLotto(lottoList);
    }

    public LottoTotalResult calcLottoResult(Lotto winLotto, int bonusLottoNumber, int inputMoney) {
        return LottoCalculator.calculate(inputMoney, lottoList, winLotto, bonusLottoNumber);
    }
}
