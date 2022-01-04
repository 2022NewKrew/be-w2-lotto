package view;

import domain.Matching;
import domain.Player;

public class MatchingView {
    private final Matching matching;
    private final Player player;
    public MatchingView(Matching matching, Player player) {
        this.matching = matching;
        this.player = player;
    }
    public void PrintMatchResult()
    {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " +matching.getMatchMoneyByKey(3)+ "개");
        System.out.println("4개 일치 (50000원)- " +matching.getMatchMoneyByKey(4)+ "개");
        System.out.println("5개 일치 (1500000원)- " +matching.getMatchMoneyByKey(5)+ "개");
        System.out.println("6개 일치 (2000000000원)- " +matching.getMatchMoneyByKey(6)+ "개");
        System.out.println("총 수익률은 "+ matching.getTotalMatchMoney()/ player.getLottoList().size() +"%입니다.");

    }
}
