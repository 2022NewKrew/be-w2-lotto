package step3.input;

import step3.lotto.LottoConfig;

import java.util.List;

public class Validator {
    public static void checkPurchaseMoney(Object money) {
        if ((int) money < 1000) {
            throw new IllegalArgumentException("최소 입력 금액은 1000원 입니다.");
        }
    }

    public static void checkLottoNum(List<Integer> lottoNum) {
        if(lottoNum.size() != LottoConfig.LOTTO_TICKET_LEN) {
            throw new IllegalArgumentException("로또 번호의 갯수는 6개 입니다.");
        }
        lottoNum.stream().forEach(Validator::numberValidity);
    }

    public static void numberValidity(int num) {
        if(num < 0 || num > 45) {
            throw new IllegalArgumentException("숫자의 범위는 1~45 입니다.");
        }
    }

    public static void checkSelfAmount(int buyAmount, int selfAmount) {
        if(selfAmount < 0) {
            throw new IllegalArgumentException("0 이상을 입력하세요.");
        }
        if(buyAmount < selfAmount) {
            throw new IllegalArgumentException("구매한 티켓 갯수 보다 많습니다.");
        }
    }

    public static void checkBonus(int bonus, List<Integer> targetNums) {
        numberValidity(bonus);
        if(targetNums.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }
}
