package view;

import domain.Result;
import enums.Rank;

import java.util.Map;

public class ResultView {


    private Result result;

    public ResultView(Result result) {
        this.result = result;
    }

    public void showResult() {
        System.out.println("당첨 통계");
        Map<Rank, Integer> prizeList = result.getPrizeList();
        for (Map.Entry<Rank,Integer> entry : prizeList.entrySet()){
            System.out.print(ResultMessage(entry));
        }
    }

    private String ResultMessage(Map.Entry<Rank, Integer> entry){
        if(entry.getKey() == Rank.NOMATCH){
            return "";
        }
        String res = String.valueOf(entry.getKey().getCountOfMatch());
        res += "개 일치";
        if(entry.getKey() == Rank.SECOND){
            res += ", 보너스 볼 일치";
        }
        res += "(" + entry.getKey().getWinningMoney() + "원)- " + entry.getValue() + "개\n";
        return res;
    }


    public void showYield() {
        System.out.printf("총 수익률은 %.2f%%입니다.", result.calculateYield());
    }


}
