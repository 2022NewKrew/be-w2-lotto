package domain;

import java.util.Collections;
import java.util.List;

public final class LottoTicket {

    private final List<Integer> numbers;
    private final LottoStatus purchaseWay;

    public LottoTicket(List<Integer> numbers, LottoStatus purchaseWay) {
        this.numbers = Collections.unmodifiableList(numbers);
        this.purchaseWay = purchaseWay;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public LottoStatus getPurchaseWay() {
        return purchaseWay;
    }
}
