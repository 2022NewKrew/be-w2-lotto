package lotto.domain;

import java.util.*;

public class LottoShop {
    public static final int PRICE = 1000;

    private Set<Integer> winnerNumber = new HashSet<>();

    public Set<Integer> getWinnerNumber() {
        return Collections.unmodifiableSet(winnerNumber);
    }

    public void setWinnerNumber(Set<Integer> winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    /**
     * {@link Gambler}의 돈으로 로또 구매
     */
    public void sellLottoTicket(Gambler gambler, int moneyToBuy) {
        int sellCount = moneyToBuy / PRICE;

        for (int i=0; i<sellCount; ++i) {
            Set<Integer> numbers = RandomLottoNumberGenerator.generateRandomLottoNumbers();
            gambler.addLottoTicket(new LottoTicket(numbers));
        }
    }
}
