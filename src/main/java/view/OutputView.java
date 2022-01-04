package view;

import domain.Lotto;
import domain.Result;
import enums.Rank;
import service.ResultService;

import java.util.ArrayList;

import static utils.Symbol.REWARD_MESSAGE;

public class OutputView {
    public OutputView(){

    }

    public void printPurchaseLottoList(ArrayList<Lotto> lottos){
        for(Lotto lotto: lottos){
            System.out.println(lotto);
        }
    }

    public void printResult(ResultService resultService){
        System.out.println();
        System.out.println(REWARD_MESSAGE);
        System.out.println("---------");
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks){
            System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getCountOfMatch(),
                    rank.getWinningMoney(), resultService.getCountRank(rank));
        }
        System.out.printf("총 수익률은 %d%%입니다.%n",resultService.getProfitRate());
    }
}
