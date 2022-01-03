package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoViewInput {
    static public Integer lottoInitialInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextInt();
    }

    private static List<Integer> resultToList(String stringAry){
        List<String> resultListString = new ArrayList<>(Arrays.asList(stringAry.split(",")));
        List<Integer> resultListInteger = new ArrayList<>();
        for(int i = 0 ; i < resultListString.size() ; i++){
            resultListInteger.add(Integer.parseInt(resultListString.get(i)));
        }
        return resultListInteger;
    }

    static public List<Integer> lottoInputResult(){
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return resultToList(sc.nextLine());
    }
}
