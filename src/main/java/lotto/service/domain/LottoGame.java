package lotto.service.domain;

import java.util.List;

public class LottoGame {
    private List<LottoTicket> lottoTickets ;

    public LottoGame(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    //TODO : winningNumber가 입력이 완료되면 자동 실행
    public void announceLottoWinningNumber(List<Integer> winningNumbers){
        lottoTickets.stream().forEach(t->t.setPrizeDetails(winningNumbers));
    }
    public void announceLottoWinningNumber(List<Integer> winningNumbers, int bonusNumber){
        lottoTickets.stream().forEach(t->t.setPrizeDetails(winningNumbers, bonusNumber));
    }
}
