package repository;

import database.LottoInfo;

public class LottoInfoRepository {
    LottoInfo lottoInfo = LottoInfo.getLottoInfo();

    public void insertMoney(int money) {
        lottoInfo.setMoney(money);
    }

    public void insertAmountManual(int amountManual) {
        lottoInfo.setAmountOfManual(amountManual);
    }

    public int getMoney() {
        return lottoInfo.getMoney();
    }
}
