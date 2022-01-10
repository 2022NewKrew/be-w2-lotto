package domain;

import domain.tickets.ManualTicket;
import domain.tickets.Ticket;
import domain.tickets.Tickets;
import domain.tickets.WinningTicket;
import exceptions.OverPriceException;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// 로또를 구매하는 구매자
// 구매자는 로또를 구매할 금액, 내가 구매한 로또 티켓 목록, 내가 얻은 당첨금을 멤버 변수로 가짐
// 추가로 구매한 수동 티켓 개수, 자동 티켓 개수, 총 티켓 개수를 멤버 변수로 가짐
// 구매자의 행위는 티켓 구매, 당첨 번호 대조, 내 수익률 계산
public class Buyer {
    // 발매받아서 소유하고 있는 로또 티켓
    private Tickets myTickets;
    // 당첨 정보
    private final List<Integer> winningInfo = new ArrayList<>(Collections.nCopies(RewardRule.getRewardName().size(), 0));
    // 로또 당첨으로 딴 당첨금
    private long revenue;

    // ============================ 티켓 구매 ============================
    public void ticketsToMyPocket(Tickets tickets) {
        this.myTickets = tickets;
    }

    // ============================ 티켓 구매 ============================
    // 내가 가진 티켓들을 보여주기
    public Tickets showMyTickets() {
        return this.myTickets;
    }

    // ============================ 티켓 당첨 확인 ============================
    // 내가 가진 모든 티켓에 대해 당첨 정보 업데이트
    public void calculateWinningInfo(WinningTicket winningTicket) {
        for (Ticket ticket : this.myTickets.getTickets()) {
            String rewardName = calculatedWinningPlace(ticket, winningTicket);
            updateWinningInfo(rewardName);
        }
    }

    // 등수별 당첨 티켓 개수 업데이트
    private void updateWinningInfo(String rewardName) {
        if (Objects.equals(rewardName, "")) {
            return;
        }
        int rewardNameIndex = RewardRule.valueOf(rewardName).ordinal();
        this.winningInfo.set(rewardNameIndex, this.winningInfo.get(rewardNameIndex) + 1);
    }

    // 당첨 티켓과 겹치는 수를 기반으로 몇 등을 했는지
    private String calculatedWinningPlace(Ticket ticket, WinningTicket winningTicket) {
        int matchCount = matchCountForTicket(ticket, winningTicket);
        boolean isBonus = isBonus(ticket, winningTicket.getBonusBall());
        if (isBonus && matchCount == 5) {
            return RewardRule.getRewardNameWithBonus();
        }
        return RewardRule.getRewardNameWithoutBonus().get(matchCount);
    }

    // 내가 가진 티켓이 당첨 티켓과 몇개 겹치는지
    private int matchCountForTicket(Ticket ticket, WinningTicket winningTicket) {
        int matchCount = 0;
        for (int i = 0; i < GroundRule.NUM_OF_SELECTION; i++) {
            int winningNumber = winningTicket.getSelectedNumbers().get(i);
            matchCount += DataFormatting.booleanToInteger(isMatched(ticket, winningNumber));
        }
        return matchCount;
    }

    // 내 특정 티켓이 당첨 번호를 포함하는지
    private Boolean isMatched(Ticket ticket, int winningNumber) {
        return ticket.getSelectedNumbers().contains(winningNumber);
    }

    // 내 특정 티켓이 보너스 숫자를 포함하는지
    private Boolean isBonus(Ticket ticket, int bonusBall) {
        return ticket.getSelectedNumbers().contains(bonusBall);
    }

    // ============================ 당첨금 및 수익률 계산 ============================
    // 나의 당첨금 계산
    public void calculateRevenue() {
        for (int i = 0; i < this.winningInfo.size(); i++) {
            String rewardName = RewardRule.getRewardName().get(i);
            this.revenue += ((long) RewardRule.valueOf(rewardName).getReward() * this.winningInfo.get(i));
        }
    }

    // 수익률 계산
    public int getYield() {
        int purchasedPrice = 0;
        for (Ticket ticket : myTickets.getTickets()) {
            purchasedPrice += ticket.getPrice();
        }
        return (int) ((this.revenue - purchasedPrice) * 100 / purchasedPrice);
    }

    // Getter
    public List<Integer> getWinningInfo() {
        return this.winningInfo;
    }

}
