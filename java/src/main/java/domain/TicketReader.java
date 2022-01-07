package domain;

import spark.Request;
import util.InputChecker;
import view.LottoView;
import view.LottoWebView;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * LottoController에서 로또 티켓 당첨 등급을 분류하는 로직을 TicketReader로 이전하여 관리
 * LottoController가 너무 비대해짐에 따라 만들어진 클래스로 LottoController와 마찬가지로 CLI, API용 메서드가 별도 존재
 */
public class TicketReader {

    private List<Integer> winningNumber;
    private int bonusNumber;

    //for CLI
    public Map<Rank, Integer> classifyTicketRank(Lotto lotto,
                                                 LottoView view,
                                                 InputChecker checker,
                                                 List<LottoTicket> tickets) {
        winningNumber = inputWinningNumber(lotto, view, checker);
        bonusNumber = inputBonusNumber(view, checker);
        return setTicketRank(tickets);
    }

    //for Web
    public Map<Rank, Integer> classifyTicketRank(Lotto lotto,
                                                 LottoWebView view,
                                                 InputChecker checker,
                                                 List<LottoTicket> tickets,
                                                 Request request) {
        winningNumber = inputWinningNumber(lotto, view, checker, request);
        bonusNumber = inputBonusNumber(view, checker, request);
        return setTicketRank(tickets);
    }

    //for CLI
    private List<Integer> inputWinningNumber(Lotto lotto, LottoView view, InputChecker checker) {
        var winningNumber = view.inputIntegerList("지난 주 당첨 번호를 입력해 주세요.");
        checker.checkTicketNumber(lotto, winningNumber);

        return winningNumber;
    }

    //for Web
    private List<Integer> inputWinningNumber(Lotto lotto, LottoWebView view, InputChecker checker, Request request) {
        winningNumber = view.inputIntegerList(request.queryParams("winningNumber"));
        checker.checkTicketNumber(lotto, winningNumber);

        return winningNumber;
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

    private int inputBonusNumber(LottoView view, InputChecker checker) {
        int bonusNumber = view.inputInt("보너스 볼을 입력해 주세요.");
        checker.checkBonusNumber(winningNumber, bonusNumber);

        return bonusNumber;
    }

    private int inputBonusNumber(LottoWebView view, InputChecker checker, Request request) {
        int bonusNumber = view.inputInt(request, "bonusNumber");
        checker.checkBonusNumber(winningNumber, bonusNumber);

        return bonusNumber;
    }
}
