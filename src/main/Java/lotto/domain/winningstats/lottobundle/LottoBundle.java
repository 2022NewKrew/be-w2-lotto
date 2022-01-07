package lotto.domain.winningstats.lottobundle;

public class LottoBundle {
    private final long lottoPurchaseMoney;
    private final LottoList lottoList;

    public LottoBundle(long lottoPurchaseMoney) {
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        long count = getCount();
        this.lottoList = new LottoList(count);
    }

    public long getCount() {
        final long LOTTO_PRICE = 1000;
        return lottoPurchaseMoney / LOTTO_PRICE;
    }

    public long getLottoPurchaseMoney() {
        return lottoPurchaseMoney;
    }

    public LottoList getLottoList() {
        return lottoList;
    }

    public String printLottoBundle() {
        return lottoList.printLottoList().toString();

    }
}
