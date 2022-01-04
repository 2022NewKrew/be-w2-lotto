package lottogame.domain.lottery;

import lottogame.domain.RandomCollection;

public class LotteryTicketFactory {
    private LotteryTicketFactory() {

    }

    public static LotteryTicket create() {
        LotteryNumbers lotteryNumbers = LotteryNumbersFactory.create(RandomCollection.returnNumbers());
        return new LotteryTicket(lotteryNumbers);
    }
}
