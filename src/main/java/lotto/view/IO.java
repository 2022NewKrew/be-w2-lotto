package lotto.view;

import lotto.dto.LottoResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IO {
    private static Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 번호을 입력해주세요. -- 띄어쓰기로 구별 ex) 1 2 3 4 5 6";

    private static final String aBuyNums = "%d개를 구매했습니다.";
    private static final String aResults = "당첨통계\n--------";
    private static final String aResultsPerNum = "%d개 일치 (%d원) - %d개";
    private static final String aEarnRate = "총 수익률은 %d %%입니다.";

    private static final int lottoPrice = 1000;
    private static final List<Integer> prices = Arrays.asList(5000, 50000, 1500000, 2000000000);

    public IO() {
    }

    public int start(){
        int amount = enterPurchaseAmount();
        int itemCnt = printAndGetAmount(amount);
        return itemCnt;
    }

    private int enterPurchaseAmount(){
        System.out.println(qPrice);
        int amount = scanner.nextInt();
        return amount;
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

        while (scanner.hasNextInt() && prevNums.size()<5){
            prevNums.add(scanner.nextInt());
        }
        return prevNums;
    }

    // input: 3~6개 일치 순서대로 일치하는 로또 개수(nums)와 그에 해당하는 상금(prices)리스트
    public void showResults(LottoResults lottoResults){
        List<Integer> correctCnts = lottoResults.getCorrectCnts();
        int earnRate = lottoResults.getEarnRate();
        showCorrectCnts(correctCnts);
        showEarnRate(earnRate);
    }

    private void showCorrectCnts(List<Integer> cnts ){
        System.out.println(aResults);
        for(int i=0; i<cnts.size();i++){
            int correctNum = i+3;
            System.out.println(String.format(aResultsPerNum, correctNum,prices.get(i), cnts.get(i)));
        }
    }

    public void showEarnRate(int rate){
        System.out.println(String.format(aEarnRate, rate));
    }
}
