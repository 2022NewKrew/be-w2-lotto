package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
}
