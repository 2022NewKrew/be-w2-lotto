package step4.service.domain;

import java.util.List;

public class LottoTicket extends Lotto {
    private LottoResult result;

    public LottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    protected void setResult(LottoResult result) {
        this.result = result;
    }

    public LottoResult getResult() {
        return result;
    }
}
