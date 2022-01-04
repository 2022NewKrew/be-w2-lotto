package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import static domain.Lotto.END_NUMBER;
import static domain.Lotto.START_NUMBER;
public class UserInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int getPayPriceInput() {
        int result = -1;
        System.out.println("구입금액을 입력해 주세요.");
        while (!sc.hasNextInt() || ((result = sc.nextInt()) < 0)) {
            System.out.println("양의 점수를 입력해 주세요.");
            sc.next();
        }
        return result;
    }
    public static int getBonusWinningInput() {
        int result = -1;
        System.out.println("보너스 볼을 입력해 주세요.");
        while (!sc.hasNextInt() || ((result = sc.nextInt()) > END_NUMBER) || result < START_NUMBER) {
            System.out.println("1~45 사이의 당첨 번호를 입력해주세요.");
            sc.next();
        }
        return result;
    }
    public static List getWinningInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
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
        if(arrayList.stream().filter(player -> (player > END_NUMBER) || (player < START_NUMBER)).count() >0)
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
