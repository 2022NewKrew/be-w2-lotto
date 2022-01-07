package input;

import java.util.List;

public class Validator {
    public static void checkPurchaseMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("최소 입력 금액은 1000원 입니다.");
        }
    }

    public static void checkTargetNum(List<Integer> target) {
        if(target.size() != 6) {
            throw new IllegalArgumentException("당첨 번호의 갯수는 6개 입니다.");
        }
    }
}
