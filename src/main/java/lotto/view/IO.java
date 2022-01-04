package lotto.view;

import lotto.dto.LottoResults;
import lotto.dto.MatchNum;
import lotto.utils.Rank;
import lotto.utils.RankMap;

import java.util.*;

public class IO {
    private static Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 번호을 입력해주세요. -- 띄어쓰기로 구별 ex) 1 2 3 4 5 6";
    private static final String qBonusNum = "보너스 볼을 입력해 주세요.";

    private static final String aBuyNums = "%d개를 구매했습니다.";
    private static final String aResults = "당첨통계\n--------";
    private static final String aResultsPerNum = "%d개 일치 (%d원) - %d개";
    private static final String aResultsBonusMatch = "%d개 일치, 보너스볼 일치 (%d원) - %d개";
    private static final String aEarnRate = "총 수익률은 %d %%입니다.";

    private static final int lottoPrice = 1000;

    public IO() {
    }

    public int start(){
        int amount = enterPurchaseAmount();
        int itemCnt = printAndGetAmount(amount);
        return itemCnt;
    }

    public MatchNum enterMatchNums(){
        List<Integer> prevNums = enterPrevNums();
        int bonusNum = enterBonusNum();
        MatchNum matchNum = new MatchNum(prevNums, bonusNum);
        return matchNum;
    }

    private int enterPurchaseAmount(){
        System.out.println(qPrice);
        int amount = scanner.nextInt();
        return amount;
    }

    private int enterBonusNum(){
        System.out.println(qBonusNum);
        int num = scanner.nextInt();
        return num;
    }

    private int printAndGetAmount(int money){
        int itemCnt = money/lottoPrice;
        System.out.println(String.format(aBuyNums, itemCnt));
        return itemCnt;
    }

    public void printPurchasedLottos(List<List<Integer>> lottos){
        for(List<Integer> lotto: lottos){
            System.out.println(Arrays.toString(lotto.toArray()));
        }
    }

    public List<Integer> enterPrevNums(){
        System.out.println(qPrevNums);
        List<Integer> prevNums = new ArrayList<Integer>();

        while (prevNums.size()<6 && scanner.hasNextInt()){
            prevNums.add(scanner.nextInt());
        }
        return prevNums;
    }

    public void showResults(LottoResults lottoResults){
        RankMap rankMap = lottoResults.getRankMap();
        int earnRate = lottoResults.getEarnRate();
        showCorrectCnts(rankMap);
        showEarnRate(earnRate);
    }

    private void showCorrectCnts(RankMap rankMap){
        System.out.println(aResults);
        for(Rank rank: rankMap.getKeySet()){
            showCorrectCntsPerLine(rank, rankMap.getValue(rank));
        }
    }

    private void showCorrectCntsPerLine(Rank rank, int cnt){
        if (rank==rank.SECOND){ //bonus number match
            System.out.println(String.format(aResultsBonusMatch, 5, rank.getWinningMoney(), cnt));
            return;
        }
        System.out.println(String.format(aResultsPerNum, rank.getCountOfMatch(), rank.getWinningMoney(), cnt));
    }

    public void showEarnRate(int rate){
        System.out.println(String.format(aEarnRate, rate));
    }
}
