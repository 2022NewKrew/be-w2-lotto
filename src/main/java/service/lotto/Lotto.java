package service.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> lotto;
    private LottoResult result;

    protected Lotto(List<Integer> lotto) {
        this.lotto = lotto;
        this.result = LottoResult.UNIDENTIFIED;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public LottoResult getResult() {
        return result;
    }

    public int getPrizeMoney() {
        return result.getPrizeMoney();
    }

    public void confirmTheWin(List<Integer> winningNumbers, int bonusBall) {
        if (result != LottoResult.UNIDENTIFIED)
            return;

        this.result = LottoResult.of(
                (int) winningNumbers.stream()
                        .filter(lotto::contains)
                        .count() ,
                lotto.contains(bonusBall)
        );
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
