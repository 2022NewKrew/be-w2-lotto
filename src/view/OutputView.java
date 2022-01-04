package view;

import domain.Lotto;
import domain.Ranking;
import domain.User;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String BUYING_FORMAT = "%d개를 구매했습니다.\n";

    private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n";
    private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String RESULT_FORMAT = "총 수익률은 %.2f입니다.\n";


    private static OutputView instance;

    private OutputView () { }

    public void printNumberOfBuy(int numberOfBuy){
        System.out.printf(BUYING_FORMAT,numberOfBuy);
    }
    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult (User user) {
        System.out.printf(HEAD_FORMAT);
        Map<Ranking, Integer> ranking = user.getRanking();
        for(Ranking rank : Ranking.values()){
            System.out.printf(BODY_FORMAT, rank.getSameNumber(), rank.getPrice(), ranking.get(rank));
        }
        System.out.printf(RESULT_FORMAT,user.getYield());
    }

    public static OutputView getInstance () {
        if (instance == null) instance = new OutputView();
        return instance;
    }

}