package step4.lotto;

import step4.lotto.domain.LottoTicket;

public interface LottoCreater {
    int NUM_OF_LOTTERY_NUMBERS = 6;
    int BIGGEST_LOTTONUM = 45;
    public LottoTicket create();
}