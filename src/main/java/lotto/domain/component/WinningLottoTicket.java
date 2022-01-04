package lotto.domain.component;

public class WinningLottoTicket {
    private LottoTicket winningTicket;
    private LottoNumber bonusBall;

    public WinningLottoTicket(LottoTicket winningTicket, LottoNumber bonusBall) {
        this.winningTicket = winningTicket;
        this.bonusBall = bonusBall;
    }

    public LottoTicket getWinningTicket() {
        return winningTicket;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
