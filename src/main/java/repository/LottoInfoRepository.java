package repository;

import database.LottoInfo;

public class LottoInfoRepository {
    LottoInfo lottoInfo = LottoInfo.getLottoInfo();

    public void insertMoney(int money) {
        lottoInfo.setMoney(money);
    }
}
