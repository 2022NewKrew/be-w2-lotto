package step2.domain;

import java.util.List;

public class LottoSheetWithId {

    // UserId
    private Long id;
    // 로또(6개의 번호)의 리스트
    private List<Lotto> lottoList;

    public LottoSheetWithId() {
    }

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

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
}
