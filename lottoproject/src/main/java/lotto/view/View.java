package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Util;

import java.util.*;

public class View {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInteger(String message){
        System.out.println(message);
        int inputInteger = sc.nextInt();
        sc.nextLine();
        return inputInteger;
    }

    public static List<Integer> inputIntegerArrayList(String message, String gubun){
        System.out.println(message);
        String input = sc.nextLine();
        List<Integer> inputIntegerArrayList = new ArrayList<Integer>();
        for (String string : input.split(gubun)){
            inputIntegerArrayList.add(Integer.parseInt(string));
        };
        return inputIntegerArrayList;
    }

    public static void printBuyResult(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매하였습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    public static void printRoundResult(Map<Integer,Integer> resultMap){
        int totalCount = 0;
        int totalReward = 0;
        for (int count : resultMap.values()) {
            totalCount += count;
        }
        System.out.println("당첨 통계");
        System.out.println("------------------");
        for(int i=3; i<=6; i++){
            totalCount += resultMap.getOrDefault(i,0);
            totalReward += Util.reward.get(i) * resultMap.getOrDefault(i,0);
            System.out.println(i+"개 일치"+" ("+Util.reward.get(i)+")- "+resultMap.getOrDefault(i,0)+"개");
        }
        System.out.println("총 수익률은 "+(float)totalReward*100/(totalCount*Util.lottoPrice)+"%입니다.");
    }
}
