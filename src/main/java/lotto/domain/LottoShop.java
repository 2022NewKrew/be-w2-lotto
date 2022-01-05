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
     * @param sellCount 구매할 장 수
     * @return {@link LottoTicket} 리스트
     */
    public List<LottoTicket> sellAutoLottoTicket(int sellCount) {
        return IntStream.range(0, sellCount)
                .mapToObj(i -> RandomLottoNumberGenerator.generateRandomLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public List<LottoTicket> sellManualLottoTicket(List<Set<Integer>> pickedNumbers) {
        return pickedNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}
