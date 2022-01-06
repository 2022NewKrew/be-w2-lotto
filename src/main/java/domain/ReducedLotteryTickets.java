package domain;

import dto.LotteryTicketsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReducedLotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public ReducedLotteryTickets() {
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
        return Arrays.stream(LotteryPrize.values()).collect(Collectors.toMap(Function.identity(), prize -> 0));
    }

    public LotteryTicketsDTO toDTO() {
        return new LotteryTicketsDTO(lotteryTickets.stream().map(LotteryTicket::toDTO).collect(Collectors.toList()));
    }
}
