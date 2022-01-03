package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int getIntegerInput(String msg, String errMsg) {
        int result = -1;
        System.out.println(msg);
        while (!sc.hasNextInt() || ((result = sc.nextInt()) < 0)) {
            System.out.println(errMsg);
            sc.next();
        }
        return result;
    }

    public static List getWinningInput(String msg) {
        System.out.println(msg);
        List<Integer> arrayList;
        do {
            String inputStr = sc.next();
            arrayList = Arrays.asList(inputStr.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        }
        while (!isCorrectWinningList(arrayList));
        // 적절하지 않은 로또 번호를 입력하면 다시 입력 해야 함.
        return arrayList;
    }
    private static boolean isCorrectWinningList(List<Integer> arrayList) {
        if(arrayList.stream().filter(player -> (player > 45) || (player < 1)).count() >0)
        {
            System.out.println("1~45 사이의 당첨 번호를 입력해주세요.");
            return false;
        }
        if(arrayList.size() != 6)
        {
            System.out.println("로또 번호를 6개 입력해주세요.");
            return false;
        }
        return true;
    }
}
