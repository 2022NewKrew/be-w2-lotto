package step2.domain;

import java.util.List;

public class LottoSheetWithId {

    private Long id;

    private List<Lotto> lottoList;

    public LottoSheetWithId(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
