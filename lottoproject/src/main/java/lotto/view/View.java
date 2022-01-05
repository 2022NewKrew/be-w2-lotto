package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Round;
import lotto.util.Rank;
import lotto.util.Util;

import java.util.*;

public class View {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputInteger(String message){
        System.out.println(message);
        int inputInteger = sc.nextInt();
        sc.nextLine();
        return inputInteger;
    }

    public static List<Integer> inputIntegerArrayList(String message, String gubun){
        if (!message.equals("")) System.out.println(message);
        String input = sc.nextLine();
        List<Integer> inputIntegerArrayList = new ArrayList<>();
        for (String string : input.split(gubun)){
            inputIntegerArrayList.add(Integer.parseInt(string));
        }
        return inputIntegerArrayList;
    }

    public static void printBuyResult(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매하였습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    public static void printRoundResult(Round round){
        System.out.println("당첨 통계");
        System.out.println("------------------");
        for (Rank rank : Rank.values()) {
            if(rank == Rank.NONE) continue;
            System.out.println(rank.toString()+" - "+round.findResultMap().getOrDefault(rank, 0)+"개");
        }
        System.out.println("총 수익률은 "+(float)round.findTotalReward()*100/(round.findLottoCount()*Util.LOTTO_PRICE)+"%입니다.");
    }
}
