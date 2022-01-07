package view;

import domain.Lotto;
import domain.Ranking;
import domain.User;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String BUYING_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n%s\n";
//    private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String RESULT_FORMAT = "총 수익률은 %.2f입니다.\n";


    private static OutputView instance;

    private OutputView () { }

    public void printNumberOfBuy(int numberOfManul, int numberOfAuto) {
        System.out.printf(BUYING_FORMAT, numberOfManul, numberOfAuto);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult (User user) {

        //통계 출력
        System.out.printf(HEAD_FORMAT, Ranking.stream()
                .map(rank ->
                        String.format(
                                rank.getPRINT_FORMAT(),
                                rank.getSameNumber(),
                                rank.getPrice(),
                                user.getRanking(rank)
                        )
                ).collect(joining())
        );

        //수익률 출력
        System.out.printf(RESULT_FORMAT,user.getProfitRatio());
    }

    public static OutputView getInstance () {
        if (instance == null) instance = new OutputView();
        return instance;
    }

}