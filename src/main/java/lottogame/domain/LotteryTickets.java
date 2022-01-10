package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public LotteryTickets(List<List<Integer>> integers, int count) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(new LotteryTicket(integers.get(i)));
        }
        this.lotteryTickets = lotteryTickets;
    }

    public Ranks rankTickets(WinningTicket winningTicket) {
        List<Rank> ranks = new ArrayList<>();
        for (var lotteryTicket : lotteryTickets) {
            Rank rank = winningTicket.rankTicket(lotteryTicket);
            ranks.add(rank);
        }
        return new Ranks(ranks);
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    public LotteryTickets combine(LotteryTickets tickets) {
        List<LotteryTicket> combineTickets = Stream.concat(lotteryTickets.stream(), tickets.lotteryTickets.stream())
                .collect(Collectors.toList());
        return new LotteryTickets(combineTickets);
    }

    public int getCount() {
        return lotteryTickets.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LotteryTickets that = (LotteryTickets) object;
        return Objects.equals(lotteryTickets, that.lotteryTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryTickets);
    }
}
