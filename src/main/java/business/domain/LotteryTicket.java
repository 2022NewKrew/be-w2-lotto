package business.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTicket implements Iterable<LotteryNumbers> {

    private final List<LotteryNumbers> lotteryNumbersList;

    public LotteryTicket(List<LotteryNumbers> lotteryNumbersList) {
        if (!isLotteryNumberListValid(lotteryNumbersList)) {
            throw new IllegalArgumentException("로또 티켓을 생성할 수 없습니다.");
        }
        this.lotteryNumbersList = Collections.unmodifiableList(lotteryNumbersList);
    }

    public static LotteryTicket union(LotteryTicket t1, LotteryTicket t2) {
        return new LotteryTicket(
            Stream.concat(t1.lotteryNumbersList.stream(), t2.lotteryNumbersList.stream())
                .collect(Collectors.toList()));
    }

    private boolean isLotteryNumberListValid(List<LotteryNumbers> lotteryNumbersList) {
        return lotteryNumbersList != null;
    }

    public int getSize() {
        return this.lotteryNumbersList.size();
    }

    public Ranks calculateRankBy(LotteryResult lotteryResult) {
        return new Ranks(this.lotteryNumbersList.stream().map(lotteryResult::calculateRank)
            .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "LotteryTicket{" + "lotteryNumbersList=" + lotteryNumbersList + '}';
    }

    @Override
    public Iterator<LotteryNumbers> iterator() {
        return lotteryNumbersList.iterator();
    }
}
