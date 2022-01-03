package domain;

import java.util.List;

public class LottoSheet {

    private List<Lotto> lottoList;

    public LottoSheet(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
