package repository;

import database.LottoInfo;

public class LottoInfoRepository {
    private static LottoInfoRepository lottoInfoRepository = null;
    private final LottoInfo lottoInfo = LottoInfo.getLottoInfo();

    private LottoInfoRepository() {
    }

    public static LottoInfoRepository getLottoInfoRepository() {
        if (lottoInfoRepository == null) {
            lottoInfoRepository = new LottoInfoRepository();
        }
        return lottoInfoRepository;
    }

    public void insertMoney(int money) {
        lottoInfo.setMoney(money);
    }

    public void insertAmountManual(int amountManual) {
        lottoInfo.setAmountOfManual(amountManual);
    }

    public int getMoney() {
        return lottoInfo.getMoney();
    }

    public int getAmountManual() {
        return lottoInfo.getAmountOfManual();
    }

    public int getAmountAuto() {
        return lottoInfo.getMoney() / 1000 - lottoInfo.getAmountOfManual();
    }
}
