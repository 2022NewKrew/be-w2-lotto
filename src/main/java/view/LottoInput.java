package view;

import controller.BuyLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    private static Scanner sc = new Scanner(System.in);
    private static final String NUMBER_SPLIT_REGEX = ", ";

    public static void getBuyLottoPrize(){
        System.out.println("구입 금액을 입력해 주세요.");
        BuyLotto buyLotto = new BuyLotto(sc.nextInt());
    }

    public static void getLastPrizeNum(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastNumbersString = sc.next();


    }
    private List<Integer> parseLottoNumbers(String numberString){
        String[] spt = numberString.split(NUMBER_SPLIT_REGEX);
        return  Arrays.stream(spt).map(Integer::parseInt).collect(Collectors.toList());
    }
}
