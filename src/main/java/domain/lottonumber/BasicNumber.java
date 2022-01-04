package domain.lottonumber;

public class BasicNumber extends LottoNumber {

    public BasicNumber(int lottoNumber) {
        super(lottoNumber);
    }

    @Override
    public boolean isBonusNumber() {
        return false;
    }
}
