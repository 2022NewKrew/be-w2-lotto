package lotto.view;

import lotto.domain.WinningLotto;
import lotto.domain.LottoGame;
import lotto.util.Rank;
import java.util.ArrayList;

public class OutputView {
    public static void displayPurchaseGames(int manualNumber, int autoNumber){
        System.out.println("수동으로 " + manualNumber + "장, 자동으로 " + autoNumber + "개를 구매했습니다.");
    }

    public static void displayPurchasedNumbers(ArrayList<LottoGame> lottoGamesNumber){
        for (LottoGame lottoNumbers : lottoGamesNumber){
            displayCandidateNumber(lottoNumbers.getCandidateNumbers());
        }
    }

    public static void displayCandidateNumber(ArrayList<Integer> CandidateNumbers){
        for (Integer lottoNumber : CandidateNumbers){
            System.out.print(" " + lottoNumber);
        }
        System.out.print("\n");
    }

    public static void displayWinningResults(WinningLotto winningLotto){
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : winningLotto.getWinningCases()){
            System.out.println(rank.getCountOfMatch()+"개 일치 ("+ rank.getWinningMoney() +"원)- "+rank.getResultCount()+"개");
        }
        System.out.println("총 수익률은 "+ winningLotto.getWinningRate() +"%"+"입니다.");
    }
}
