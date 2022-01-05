package input;
import lotto.LottoConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 역할 - 입력받고 Validate 까지(입력 자체는 InputResourceManager 클래스 활용)
 */
public class CommandLineInputView implements InputView {
    @Override
    public int inputBuyTicketAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int ticketAmount = getPurchaseAmount();
        System.out.println(ticketAmount + "개를 구매했습니다.");

        return ticketAmount;
    }

    @Override
    public List<Integer> inputLottoNum() {
        List<Integer> lottoNum = Arrays.asList(InputResourceManager.nextLine()
                        .trim().replaceAll(" ", "").split(","))
                        .stream().map(Integer::parseInt).collect(Collectors.toList());
        Validator.checkLottoNum(lottoNum);
        return lottoNum;
    }

    @Override
    public int inputBonusNum(List<Integer> targetNums) {
        System.out.println("보너스 볼 번호를 입력해주세요");
        int bonus = Integer.parseInt(InputResourceManager.nextLine());
        Validator.checkBonus(bonus, targetNums);
        return bonus;
    }

    @Override
    public int inputAmoundOfSelf(int buyAmount) {
        int selfAmount = InputResourceManager.nextInt();
        Validator.checkSelfAmount(buyAmount, selfAmount);
        return selfAmount;
    }

    private int getPurchaseAmount() {
        int purchaseFee = InputResourceManager.nextInt();
        Validator.checkPurchaseMoney(purchaseFee);
        return purchaseFee / LottoConfig.LOTTO_TICKET_PRICE;
    }
}