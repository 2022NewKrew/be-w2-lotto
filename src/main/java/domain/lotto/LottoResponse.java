package domain.lotto;

public class LottoResponse {

    private final String numbers;

    public LottoResponse(Lotto lotto) {
        this.numbers = lotto.toString();
    }

    public String getNumbers() {
        return numbers;
    }
}
