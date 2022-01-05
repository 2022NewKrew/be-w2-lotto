package step4.input;

import step4.lotto.LottoConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 역할 - 입력받고 Validate 까지(입력 자체는 InputResourceManager 클래스 활용)
 */
public class CommandLineInputView implements InputView {
    @Override
    public int inputBuyTicketAmount() {
        int ticketAmount = getPurchaseAmount();
        System.out.println(ticketAmount + "개를 구매했습니다.");

        return ticketAmount;
    }

    @Override
    public List<Integer> inputLottoNum() {
        String str = InputResourceManager.nextLine();
        List<Integer> lottoNum = parse(str);
        Validator.checkLottoNum(lottoNum);
        return lottoNum;
    }

    @Override
    public List<Integer> inputWinningNum() {
        String str = InputResourceManager.nextLineWithMessage("지난주 당첨 번호를 입력해주세요. 입력 예시 : 1,2,3,4,5,6");
        List<Integer> lottoNum = parse(str);
        Validator.checkLottoNum(lottoNum);
        return lottoNum;
    }

    @Override
    public int inputBonusNum(List<Integer> targetNums) {
        int bonus = InputResourceManager.nextIntWithMessage("보너스 볼 번호를 입력해주세요");
        Validator.checkBonus(bonus, targetNums);
        return bonus;
    }

    @Override
    public int inputAmoundOfSelf(int buyAmount) {
        int selfAmount = InputResourceManager.nextInt();
        Validator.checkSelfAmount(buyAmount, selfAmount);
        return selfAmount;
    }

    private List<Integer> parse(String string) {
        return Arrays.asList(string.trim().replaceAll(" ", "").split(","))
                        .stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private int getPurchaseAmount() {
        int purchaseFee = InputResourceManager.nextIntWithMessage("구입 금액을 입력해주세요.");
        Validator.checkPurchaseMoney(purchaseFee);
        return purchaseFee / LottoConfig.LOTTO_TICKET_PRICE;
    }
}