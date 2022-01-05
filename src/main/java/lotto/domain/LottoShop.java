package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {
    public static final int PRICE = 1000;

    private Set<Integer> winnerNumber;
    private int bonusBall;

    public Set<Integer> getWinnerNumber() {
        return Collections.unmodifiableSet(winnerNumber);
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public void setWinnerNumber(Set<Integer> winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
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

    /**
     * @param pickedNumbers 뽑은 번호들 목록
     * @return {@code pickedNumbers}로 만든 {@link LottoTicket} 리스트
     */
    public List<LottoTicket> sellManualLottoTicket(List<Set<Integer>> pickedNumbers) {
        return pickedNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}
