package step4.input;

import step4.util.TypeConverter;
import step4.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 역할 - 입력받고 Validate 까지(입력 자체는 InputResourceManager 클래스 활용)
 */
public class ConsoleInput {
    public int inputBuyTicketAmount() {
        int purchaseFee = ConsoleResourceManager.nextIntWithMessage("구입 금액을 입력해주세요.");
        Validator.checkPurchaseMoney(purchaseFee);
        int ticketAmount = TypeConverter.MoneyToAmount(purchaseFee);
        System.out.println(ticketAmount + "개를 구매했습니다.");
        return ticketAmount;
    }

    public List<Integer> inputLottoNum() {
        String str = ConsoleResourceManager.nextLine();
        List<Integer> lottoNum = TypeConverter.StringToIntegerList(str);
        return lottoNum;
    }

    public List<Integer> inputWinningNum() {
        String str = ConsoleResourceManager.nextLineWithMessage("지난주 당첨 번호를 입력해주세요. 입력 예시 : 1,2,3,4,5,6");
        List<Integer> lottoNum = TypeConverter.StringToIntegerList(str);
        return lottoNum;
    }

    public int inputBonusNum() {
        int bonus = ConsoleResourceManager.nextIntWithMessage("보너스 볼 번호를 입력해주세요");
        return bonus;
    }

    public int inputAmoundOfSelf(int buyAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int selfAmount = ConsoleResourceManager.nextInt();
        Validator.checkSelfAmount(buyAmount, selfAmount);
        return selfAmount;
    }

    public List<List<Integer>> inputSelfNums(int manualTicketAmount) {
        if(manualTicketAmount == 0) return new ArrayList<List<Integer>>();
        System.out.println("수동으로 구매할 번호를 입력하세요");
        return IntStream.range(0, manualTicketAmount)
                .mapToObj(i -> inputLottoNum())
                .collect(Collectors.toList());
    }
}