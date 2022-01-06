package dto;

import domain.Matching;
import domain.Player;
import domain.Prize;

import java.util.ArrayList;
import java.util.List;

import static domain.Player.LOTTO_PRICE;
import static domain.Prize.SECOND_PRIZE;

public class LottosResult {
    private double totalRateOfReturn = 1;
    private List<String> message = new ArrayList<>();

    public double getTotalRateOfReturn() {
        return totalRateOfReturn;
    }

    public void setTotalRateOfReturn(double totalRateOfReturn) {
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
    public void makeRender(Matching matching, Player player) {
        for (Prize prize : Prize.values()) {
            Integer prizeCount = matching.getPrizeCount(prize);

            message.add(prize == SECOND_PRIZE ?
                    String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개", prize.getMatchingNumber(), prize.getPrizeMoney(), prizeCount) :
                    String.format("%d개 일치 (%d원)- %d개", prize.getMatchingNumber(), prize.getPrizeMoney(), prizeCount)
            );
        }
        setTotalRateOfReturn(matching.calTotalEarningRate(player.getPayTotalCount() * LOTTO_PRICE));
    }
}
