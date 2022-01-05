package step3.lotto.domain;

import step3.input.Validator;

import java.util.List;

public class LottoTicket extends Lotto {

    private LottoResult result;

    public LottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    protected void checkLottoNum(List<Integer> numbers) {
        Validator.checkLottoNum(numbers);
    }

    protected void setResult(LottoResult result) {
        this.result = result;
    }

    public LottoResult getResult() {
        return result;
    }
}
