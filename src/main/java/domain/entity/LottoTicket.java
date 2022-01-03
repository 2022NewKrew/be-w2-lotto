package domain.entity;

import java.util.List;

public class LottoTicket {

    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    public int countWinningNumber(LottoTicket winningTicket) {
        return (int)(lottoNumbers.stream()
                .filter(number -> winningTicket.contains(number))
                .count());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
