package controller;

import domain.*;
import domain.tickets.Ticket;
import domain.tickets.Tickets;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    private Buyer buyer;
    private LotteryCentral lotteryCentral;
    private View view;
    private DataVerifier exceptionHandler = new DataVerifier();

    public LotteryController(Buyer buyer, LotteryCentral lotteryCentral, View view) {
        this.buyer = buyer;
        this.lotteryCentral = lotteryCentral;
        this.view = view;
    }

    // 구매자가 방문하면 구입금액, 수동티켓수, 수동선택번호들을 물어보고 본부에서 발행해준 티켓들을 구매자에게 전달
    public void serveTicketsToBuyer() {
        // 구매자로부터 구입금액과 수동티켓 개수를 입력
        view.print("구입금액을 입력해 주세요.");
        int buyerPaid = exceptionHandler.integerFromVerifiedString(view.inputString());
        // 수동으로 구매할 티켓 수 입력
        view.print("수동으로 구매할 로또 수를 입력해 주세요.");
        int numOfManualTickets =
                exceptionHandler.verifiedNumofTickets(this.lotteryCentral.getManualTicketPrice(), exceptionHandler.integerFromVerifiedString(view.inputString()), buyerPaid);
        view.print("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualList = getManualList(numOfManualTickets);
        Tickets tickets = lotteryCentral.releaseTickets(manualList, buyerPaid);
        for (Ticket ticket : tickets.getTickets()) {
            buyer.ticketsToMyPocket(ticket);
        }
    }

    private List<List<Integer>> getManualList(int numOfManualTickets) {
        List<List<Integer>> manualList = new ArrayList<>();
        for (int i = 0; i < numOfManualTickets; i++) {
            manualList.add(exceptionHandler.verifiedTicketNumbers(view.inputString()));
        }
        return manualList;
    }

    // 구매자가 갖고있는 티켓들을 view에 출력
    public void showTickets() {
        for (Ticket ticket : this.buyer.showMyTickets().getTickets()) {
            view.print(ticket.getSelectedNumbers());
        }
    }

    // 로또 추첨
    public void drawLottery() {
        // 당첨 티켓 정보 입력
        view.print("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = exceptionHandler.verifiedTicketNumbers(view.inputString());
        view.print("보너스 볼을 입력해 주세요.");
        int bonusBall = exceptionHandler.integerFromVerifiedString(view.inputString());
        this.lotteryCentral.drawWinningTicket(winningNumbers, bonusBall);
        //
    }

    public void makeBuyerToCalculate() {
        this.buyer.calculateWinningInfo(lotteryCentral.getWinningTicket());
        this.buyer.calculateRevenue();
    }

    public void showStatistics() {
        List<Integer> winningInfo = buyer.getWinningInfo();
        view.print("당첨 통계");
        view.print("---------");
        for (int i = 0; i < winningInfo.size(); i++) {
            showWinningInfo(i, winningInfo.get(i));
        }
        view.print(String.format("총 수익률은 %d%%입니다.", this.buyer.getYield()));
    }

    private void showWinningInfo(int rewardIndex, int numberOfWinning) {
        String rewardName = RewardRule.getRewardName().get(rewardIndex);
        if (RewardRule.valueOf(rewardName).getIsBonus()) {
            view.print(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개",
                    RewardRule.valueOf(rewardName).getNumOfMatch(), RewardRule.valueOf(rewardName).getReward(), numberOfWinning));
            return;
        }
        view.print(String.format("%d개 일치, (%d원) - %d개",
                RewardRule.valueOf(rewardName).getNumOfMatch(), RewardRule.valueOf(rewardName).getReward(), numberOfWinning));
    }


}
