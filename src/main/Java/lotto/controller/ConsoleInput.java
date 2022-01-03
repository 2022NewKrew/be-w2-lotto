package lotto.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInput {
    private static final String SEPERATOR = ",";
    private static Scanner sc = new Scanner(System.in);

    public static int getLottoPurchaseMoney(){
         System.out.println("구입금액을 입력해 주세요.");
         int lottoPurChaseMoney = sc.nextInt();
         return lottoPurChaseMoney;
     }

    public static List<Integer> getLastWeekLottoNumberList() {
        System.out.println("지난 주 당첨 로또 번호를 입력해주세요.");
        int[] lastWeekLottoNumberArray = Stream.of(sc.next().split(SEPERATOR)).mapToInt(Integer::parseInt).toArray();
        List<Integer> lastWeekLottoNumberList = Arrays.stream(lastWeekLottoNumberArray).boxed().collect(Collectors.toList());
        return lastWeekLottoNumberList;
    }

}

