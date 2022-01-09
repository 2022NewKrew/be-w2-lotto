package lotto.domain.winningstats.lottobundle;

import lotto.exception.IllegalManualLottoInputException;

public class LottoBundle {
    private final long lottoPurchaseMoney;
    private final LottoList lottoList;
    private final LottoList autoLottoList;
    private final long manualLottoCount;
    private final int lottoPrice;

    public LottoBundle(long lottoPurchaseMoney,String manualLottoNumbers,int lottoPrice) throws IllegalManualLottoInputException {
        long autoCount;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        LottoList manualLottoList = new LottoList(manualLottoNumbers);
        manualLottoCount = manualLottoList.size();
        this.lottoPrice = lottoPrice;
        autoCount = getAutoCount();
        autoLottoList = new LottoList(autoCount);
        this.lottoList = manualLottoList.concat(autoLottoList);
    }

    public long getManualLottoCount() {
        return manualLottoCount;
    }

    public long getAutoCount() {
        long autoCount = lottoPurchaseMoney / this.lottoPrice - manualLottoCount;
        if(autoCount<0)
            throw new IllegalManualLottoInputException("수동으로 구매하고자 하는 수량이 총 금액보다 많습니다.");
        return autoCount;
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
