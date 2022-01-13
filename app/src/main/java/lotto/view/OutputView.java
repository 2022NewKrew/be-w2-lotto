package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Rank;

import java.util.ArrayList;

public class OutputView {
    public static void displayPurchaseGames(int manualNumber, int autoNumber){
        System.out.println("수동으로 " + manualNumber + "장, 자동으로 " + autoNumber + "개를 구매했습니다.");
    }

    public static void displayPurchasedNumbers(ArrayList<ArrayList> lottoGamesNumber){
        for (ArrayList lottoNumbers : lottoGamesNumber){
            displayCandidateNumber(lottoNumbers);
        }
    }

    public static void displayCandidateNumber(ArrayList CandidateNumbers){
        for (int idx = 0; idx < CandidateNumbers.size(); idx++){
            System.out.print(" "+CandidateNumbers.get(idx));
        }
        System.out.print("\n");
    }

    public static void displayWinningResults(Lotto lottoResults){
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : lottoResults.getWinningCases()){
            System.out.println(rank.getCountOfMatch()+"개 일치 ("+ rank.getWinningMoney() +"원)- "+rank.getResultCount()+"개");
        }
        System.out.println("총 수익률은 "+lottoResults.checkWinningRate()+"%"+"입니다.");
    }
}
