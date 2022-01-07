package domain;

import domain.tickets.ManualTicket;
import domain.tickets.Ticket;
import domain.tickets.WinningTicket;
import Exceptions.OverPriceException;
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
    // 로또를 구매한 금액
    private int purchasedPrice;
    // 구매한 티켓 개수들
    private int numOfManualTickets;
    private int numOfAutoTickets;
    private int numOfTotalTickets;
    // 발매받아서 소유하고 있는 로또 티켓
    private final List<Ticket> possessedTickets = new ArrayList<>();
    // 당첨 정보
    private final List<Integer> winningInfo = new ArrayList<>(Collections.nCopies(RewardRule.getRewardName().size(), 0));
    // 로또 당첨으로 딴 당첨금
    private long revenue;

    public void inputBasicInfo() {
        View.print("구입금액을 입력해 주세요.");
        savePurchasePrice();
        saveNumOfTotalTickets();
        View.print("수동으로 구매할 로또 수를 입력해 주세요.");
        saveNumOfManualTickets();
        this.numOfAutoTickets = this.numOfTotalTickets - this.numOfManualTickets;
    }

    // ============================ 티켓 구매 ============================
    // 구매자의 티켓 구매
    public void purchaseTickets(List<Ticket> autoTickets) {
        View.print("수동으로 구매할 번호를 입력해 주세요.");
        addManualTickets();
        addAutoTickets(autoTickets);
    }

    // 구매할 금액 저장 (---원을 주머니에서 꺼내어 지불하는 것과 같은 행위)
    private void savePurchasePrice() {
        this.purchasedPrice = inputPurchasePrice();
    }

    // 구매할 금액 입력 (---원치 구매할게요 라고 말하는 것과 같은 행위)
    private int inputPurchasePrice() {
        try {
            return DataFormatting.stringToInteger(View.inputString());
        } catch (NumberFormatException e) {
            return inputPurchasePrice();
        }
    }

    // 구매할 전체 티켓 개수 저장
    private void saveNumOfTotalTickets() {
        this.numOfTotalTickets = (int) (this.purchasedPrice / GroundRule.PRICE_OF_TICKET);
    }

    // 구매할 수동 티켓 개수 저장
    private void saveNumOfManualTickets() {
        try {
            this.numOfManualTickets = inputNumOfManualTickets();
        }
        catch (OverPriceException e) {
            View.print("지금 금액으로는 이만큼 구매할 수 없습니다.");
            saveNumOfManualTickets();
        }
        catch (NumberFormatException e) {
            View.print("숫자가 아닌 입력이 감지되었습니다.");
            saveNumOfManualTickets();
        }
    }

    // 구매할 수동 티켓 개수 입력 (-개는 수동으로 할게요)
    private int inputNumOfManualTickets() throws OverPriceException {
        int numOfManualTickets = DataFormatting.stringToInteger(View.inputString());
        if (numOfManualTickets > this.numOfTotalTickets) {
            throw new OverPriceException();
        }
        return numOfManualTickets;
    }

    // 번호 찍은 수동 티켓을 내 소유 티켓에 저장
    private void addManualTickets() {
        for (int i = 0; i < numOfManualTickets; i++) {
            this.possessedTickets.add(new ManualTicket(DataFormatting.selectedNumbers()));
        }
    }

    // 자동으로 발급받은 티켓을 내 소유 티켓에 저장
    private void addAutoTickets(List<Ticket> tickets) {
        this.possessedTickets.addAll(tickets);
    }

    // 내가 가진 티켓들을 보여주기
    public void showMyTickets() {
        View.print(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", this.numOfManualTickets, this.numOfAutoTickets));
        for (Ticket ticket : this.possessedTickets) {
            View.print(ticket.getSelectedNumbers());
        }
    }

    // ============================ 티켓 당첨 확인 ============================
    // 내가 가진 모든 티켓에 대해 당첨 정보 업데이트
    public void calculateWinningInfo(WinningTicket winningTicket) {
        for (Ticket ticket : possessedTickets) {
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
            this.revenue += (RewardRule.valueOf(rewardName).getReward() * this.winningInfo.get(i));
        }
    }

    // 수익률 계산
    public int getYield() {
        return (int) ((this.revenue - this.purchasedPrice) * 100 / this.purchasedPrice);
    }

    // Getter
    public int getNumOfAutoTickets() {
        return this.numOfAutoTickets;
    }

    public List<Integer> getWinningInfo() {
        return this.winningInfo;
    }

}
