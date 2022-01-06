package controller;

import domain.Buyer;
import domain.LotteryCentral;
import domain.RewardRule;
import view.View;

import java.util.List;

public class LotteryController {
    private Buyer buyer;
    private LotteryCentral lotteryCentral;

    public LotteryController(Buyer buyer, LotteryCentral lotteryCentral) {
        this.buyer = buyer;
        this.lotteryCentral = lotteryCentral;
    }

    public void releaseTicketsToBuyer() {
        buyer.inputBasicInfo();
        buyer.purchaseTickets(lotteryCentral.releaseAutoTickets(buyer.getNumOfAutoTickets()));
    }

    public void showTickets() {
        this.buyer.showMyTickets();
    }

    public void requireWinningTicketInfo() {
        this.lotteryCentral.inputWinningTicket();
    }

    public void makeBuyerToCalculate() {
        this.buyer.calculateWinningInfo(lotteryCentral.getWinningTicket());
        this.buyer.calculateRevenue();
    }

    public void showStatistics() {
        List<Integer> winningInfo = buyer.getWinningInfo();
        View.print("당첨 통계");
        View.print("---------");
        for (int i = 0; i < winningInfo.size(); i++) {
            showWinningInfo(i, winningInfo.get(i));
        }
        View.print(String.format("총 수익률은 %d%%입니다.", this.buyer.getYield()));
    }

    private void showWinningInfo(int rewardIndex, int numberOfWinning) {
        String rewardName = RewardRule.getRewardName().get(rewardIndex);
        if (RewardRule.valueOf(rewardName).getIsBonus()) {
            View.print(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개",
                    RewardRule.valueOf(rewardName).getNumOfMatch(), RewardRule.valueOf(rewardName).getReward(), numberOfWinning));
            return;
        }
        View.print(String.format("%d개 일치, (%d원) - %d개",
                RewardRule.valueOf(rewardName).getNumOfMatch(), RewardRule.valueOf(rewardName).getReward(), numberOfWinning));
    }



}
