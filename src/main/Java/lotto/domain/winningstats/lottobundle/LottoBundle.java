package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;

public class LottoBundle {
    private final long lottoPurchaseMoney;
    private final LottoList lottoList;
    private final LottoList autoLottoList;
    private final long manualLottoCount;

    public LottoBundle(long lottoPurchaseMoney,String manualLottoNumbers) {
        long autoCount;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        LottoList manualLottoList = new LottoList(manualLottoNumbers);
        manualLottoCount = manualLottoList.size();
        autoCount = getAutoCount();
        autoLottoList = new LottoList(autoCount);
        this.lottoList = manualLottoList.concat(autoLottoList);
    }

    public long getManualLottoCount() {
        return manualLottoCount;
    }

    public long getAutoCount() {
        final long LOTTO_PRICE = 1000;
        return lottoPurchaseMoney / LOTTO_PRICE - manualLottoCount;
    }

    public long getLottoPurchaseMoney() {
        return lottoPurchaseMoney;
    }

    public LottoList getLottoList(){
        return lottoList;
    }

    public String printAutoLottoList() {
        return autoLottoList.printLottoList();
    }
}
