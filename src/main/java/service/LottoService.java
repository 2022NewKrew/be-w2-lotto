package service;

import domain.Lotto;
import domain.LottoNormal;
import domain.LottoStatistic;

import java.util.List;

public interface LottoService {

    LottoStatistic createLottoStatistic(int purchaseCount, int normalLottoCount, int autoLottoCount);

    List<Lotto> createAutoLottoList(int autoLottoCount);

    int calculateLottoCount(int purchasePrice);

    LottoNormal createStringToLottoNumbers(String line);
}
