package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
     * @param moneyToBuy 구매 금액
     * @return 구매금액에 맞는 {@link LottoTicket} 리스트
     */
    public List<LottoTicket> sellLottoTicket(int moneyToBuy) {
        int sellCount = moneyToBuy / PRICE;
        return IntStream.range(0, sellCount)
                .mapToObj(i -> RandomLottoNumberGenerator.generateRandomLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}
