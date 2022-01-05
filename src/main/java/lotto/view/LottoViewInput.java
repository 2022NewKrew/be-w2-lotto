package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoViewInput {
    static public Integer lottoInputPayment(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");

        try {
            return sc.nextInt();
        } catch(Exception e){
            return 0;
        }
    }

    static public Integer lottoInputUserMakeCount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return sc.nextInt();
        } catch(Exception e){
            return 0;
        }
    }

    static private List<Integer> resultToList(String stringAry){
        List<String> resultListString = new ArrayList<>(Arrays.asList(stringAry.split(",")));
        List<Integer> resultListInteger = new ArrayList<>();
        for(int i = 0 ; i < resultListString.size() ; i++){
            resultListInteger.add(Integer.parseInt(resultListString.get(i)));
        }
        return resultListInteger;
    }

    static public List<Integer> lottoInputToList(Runnable runnable){
        Scanner sc = new Scanner(System.in);
        runnable.run();
        return resultToList(sc.nextLine());
    }

    static public Integer lottoInputResultBonus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

}
