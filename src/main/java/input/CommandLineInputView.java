package input;

import input.dto.InputInfo;
import lotto.LottoInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandLineInputView implements InputView {

    @Override
    public InputInfo inputBuyInfo() {
        System.out.println("구입 금액을 입력해주세요.");
        int ticketAmount = getPurchaseAmount();
        System.out.println(ticketAmount + "개를 구매했습니다.");

        return new InputInfo(ticketAmount);
    }

    @Override
    public void inputTargetNum(InputInfo inputInfo) {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        List<String> strings = Arrays.asList(InputResourceManager.scanner.nextLine()
                                                .trim().replaceAll(" ", "").split(","));
        List<Integer> target = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        Validator.checkTargetNum(target);
        inputInfo.setTarget(target);
    }

    private int getPurchaseAmount() {
        int purchaseFee = Integer.parseInt(InputResourceManager.scanner.nextLine());
        Validator.checkPurchaseMoney(purchaseFee);
        return purchaseFee / LottoInfo.LOTTO_TICKET_PRICE;
    }
}
