package domain;

import util.InputChecker;
import view.LottoView;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TicketReader {

    private List<Integer> winningNumber;
    private int bonusNumber;

    public Map<Rank, Integer> classifyTicketRank(Lotto lotto,
                                                 LottoView view,
                                                 InputChecker checker,
                                                 List<LottoTicket> tickets) {
        inputWinningNumber(lotto, view, checker);
        inputBonusNumber(view, checker);
        return setTicketRank(tickets);
    }

    private void inputWinningNumber(Lotto lotto, LottoView view, InputChecker checker) {
        winningNumber = view.inputIntegerList("지난 주 당첨 번호를 입력해 주세요.");
        checker.checkTicketNumber(lotto, winningNumber);
    }

    private Map<Rank, Integer> setTicketRank(List<LottoTicket> tickets) {
        Rank rank;
        Map<Rank, Integer> rankCount = createNewMap();

        for (var ticket : tickets) {
            rank = getRank(ticket, winningNumber, bonusNumber);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    private Map<Rank, Integer> createNewMap() {
        Map<Rank, Integer> rankCount = new TreeMap<>();

        rankCount.put(Rank.FIRST, 0);
        rankCount.put(Rank.SECOND, 0);
        rankCount.put(Rank.THIRD, 0);
        rankCount.put(Rank.FOURTH, 0);
        rankCount.put(Rank.FIFTH, 0);
        rankCount.put(Rank.ZERO, 0);

        return rankCount;
    }

    private Rank getRank(LottoTicket ticket,
                         List<Integer> winningNumber,
                         int bonusNumber) {
        int countOfMatch = ticket.countMatchedNumber(winningNumber);
        boolean matchBonus = ticket.hasBonusNumber(bonusNumber);

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private void inputBonusNumber(LottoView view, InputChecker checker) {
        bonusNumber = view.inputInt("보너스 볼을 입력해 주세요.");
        checker.checkBonusNumber(winningNumber, bonusNumber);
    }
}
