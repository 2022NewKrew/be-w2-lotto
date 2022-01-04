package domain.lottonumber;

public class BonusNumber extends LottoNumber {

    public BonusNumber(int lottoNumber) {
        super(lottoNumber);
    }

    @Override
    public boolean isBonusNumber() {
        return true;
    }
}
