package input;

import input.dto.InputInfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommandLineInputView implements InputView {

    @Override
    public InputInfo getBuyInfo() {
        System.out.println("구입 금액을 입력해주세요.");
        int ticketAmount = getPurchaseAmount();
        System.out.println(ticketAmount + "개를 구매했습니다.");

        return new InputInfo(ticketAmount);
    }

    @Override
    public void getTargetNum(InputInfo inputInfo) {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        List<String> strings = Arrays.asList(InputManager.scanner.nextLine().split(", "));
        List<Integer> target = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        inputInfo.setTarget(target);
    }

    private int getPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(InputManager.scanner.nextLine());
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("최소 입력 금액은 1000원 입니다.");
        }
        return purchaseAmount / 1000;
    }
}
