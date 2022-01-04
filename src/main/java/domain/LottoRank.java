package domain;

public enum LottoRank {
    ETC(LottoMatch.ETC, 5000L),
    FOURTH(LottoMatch.FOURTH, 50000L),
    THIRD(LottoMatch.THIRD, 1500000L),
    SECOND(LottoMatch.SECOND, 30000000L),
    FIRST(LottoMatch.FIRST, 2000000000L);

    private final LottoMatch lottoMatch;
    private final long price;

    LottoRank(LottoMatch lottoMatch, long price) {
        this.lottoMatch = lottoMatch;
        this.price = price;
    }

    public LottoMatch getLottoMatch() {
        return lottoMatch;
    }

    public long getPrice() {
        return price;
    }
}
