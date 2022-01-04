package domain;

import view.LottoView;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TicketReader {

    private List<Integer> winningNumber;
    private int bonusNumber;

    public Map<Rank, Integer> classifyTicketRank(Lotto lotto,
                                                 LottoView view,
                                                 List<LottoTicket> tickets) {
        inputWinningNumber(lotto, view);
        inputBonusNumber(view);
        return setTicketRank(tickets);
    }

    private void inputWinningNumber(Lotto lotto, LottoView view) {
        try {
            winningNumber = view.inputIntegerList("지난 주 당첨 번호를 입력해 주세요.");
            checkWinningNumber(lotto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputWinningNumber(lotto, view);
        }
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

        rankCount = new TreeMap<>();
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

    private void inputBonusNumber(LottoView view) {
        try {
            bonusNumber = view.inputInt("보너스 볼을 입력해 주세요.");
            checkBonusNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputBonusNumber(view);
        }
    }

    private void checkWinningNumber(Lotto lotto) throws IllegalArgumentException {
        if (winningNumber.size() != lotto.getNumberCount()) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        if (winningNumber.stream().distinct().count() != winningNumber.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복된 번호를 허용하지 않습니다.");
        }

        if (winningNumber.stream().anyMatch(num -> num < lotto.getMinNumber() || num > lotto.getMaxNumber())) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
        }
    }

    private void checkBonusNumber() throws IllegalArgumentException {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
