package lotto.view;

import lotto.collections.LottoLine;
import lotto.collections.LottoNumber;
import lotto.collections.AnsLottoLine;
import lotto.dto.LottoResults;
import lotto.utils.Rank;
import lotto.collections.RankMap;

import java.util.*;

public class IO {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 번호을 입력해주세요. -- 띄어쓰기로 구별 ex) 1 2 3 4 5 6";
    private static final String qBonusNum = "보너스 볼을 입력해 주세요.";

    private static final String aBuyNums = "%d개를 구매했습니다.";
    private static final String aResults = "당첨통계\n--------";
    private static final String aResultsPerNum = "%d개 일치 (%d원) - %d개";
    private static final String aResultsBonusMatch = "%d개 일치, 보너스볼 일치 (%d원) - %d개";
    private static final String aEarnRate = "총 수익률은 %d %%입니다.";

    private static final int lottoPrice = 1000;

    public static int start(){
        int amount = enterPurchaseAmount();
        return printAndGetAmount(amount);
    }

    public static AnsLottoLine enterMatchNums(){
        LottoLine prevNums = enterPrevNums();
        LottoNumber bonusNum = enterBonusNum();
        return new AnsLottoLine(prevNums, bonusNum);
    }

    private static int enterPurchaseAmount(){
        System.out.println(qPrice);
        return scanner.nextInt();
    }

    private static LottoNumber enterBonusNum(){
        System.out.println(qBonusNum);
        int num = scanner.nextInt();
        return new LottoNumber(num);
    }

    private static int printAndGetAmount(int money){
        int itemCnt = money/lottoPrice;
        System.out.println(String.format(aBuyNums, itemCnt));
        return itemCnt;
    }

    public static void printPurchasedLottos(List<LottoLine> lottos){
        for(LottoLine lotto: lottos){
            System.out.println(lotto);
        }
    }

    public static LottoLine enterPrevNums(){
        System.out.println(qPrevNums);
        Set<LottoNumber> temp = new HashSet<>();

        while (temp.size()<6 && scanner.hasNextInt()){
            temp.add(new LottoNumber(scanner.nextInt()));
        }

        return new LottoLine(temp);
    }

    public static void showResults(LottoResults lottoResults){
        RankMap rankMap = lottoResults.getRankMap();
        int earnRate = lottoResults.getEarnRate();
        showCorrectCnts(rankMap);
        showEarnRate(earnRate);
    }

    private static void showCorrectCnts(RankMap rankMap){
        System.out.println(aResults);
        for(Rank rank: rankMap.getKeySet()){
            showCorrectCntsPerLine(rank, rankMap.getValue(rank));
        }
    }



    private static void showCorrectCntsPerLine(Rank rank, int cnt){
        if (rank == Rank.SECOND){ //bonus number match
            System.out.println(String.format(aResultsBonusMatch, 5, rank.getWinningMoney(), cnt));
            return;
        }
        System.out.println(String.format(aResultsPerNum, rank.getCountOfMatch(), rank.getWinningMoney(), cnt));
    }

    public static void showEarnRate(int rate){
        System.out.println(String.format(aEarnRate, rate));
    }
}
