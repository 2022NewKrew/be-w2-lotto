package lotto.domain;

public class LottoResult {
    private LottoNumber lottoNumber;
    private Integer bonusNumber;

    public LottoResult(){

    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public void setLottoNumber(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
