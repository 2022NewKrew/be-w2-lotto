package domain;

import dto.LotteryTicketsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;
    private final int ticketPrice;

    public LotteryTickets(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        lotteryTickets = new ArrayList<>();
    }

    public Map<LotteryPrize, Integer> getPrizeCount(LotteryResult lotteryResult) {
        Map<LotteryPrize, Integer> prizeCount = createInitializedPrizeCount();
        lotteryTickets.forEach(lotteryTicket -> {
                LotteryPrize ticketLotteryPrize = LotteryPrize.getPrize(lotteryResult, lotteryTicket);
                prizeCount.put(ticketLotteryPrize, prizeCount.get(ticketLotteryPrize) + 1);
        });
        return prizeCount;
    }

    private Map<LotteryPrize, Integer> createInitializedPrizeCount() {
        return Arrays.stream(LotteryPrize.values()).collect(Collectors.toMap(Function.identity(), prize -> Integer.valueOf(0)));
    }

    public void add(LotteryTicket lotteryTicket) {
        lotteryTickets.add(lotteryTicket);
    }

    public void add(LotteryTickets lotteryTickets) {
        this.lotteryTickets.addAll(lotteryTickets.lotteryTickets);
    }

    public int getCost() {
        return ticketPrice * lotteryTickets.size();
    }

    public LotteryTicketsDTO toDTO() {
        return new LotteryTicketsDTO(lotteryTickets.stream().map(lotteryTicket -> lotteryTicket.toDTO()).collect(Collectors.toList()));
    }
}
