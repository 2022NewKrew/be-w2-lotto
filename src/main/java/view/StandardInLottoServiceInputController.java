package view;

import valid.ConditionCheck;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class StandardInLottoServiceInputController implements LottoServiceInputController {

    private final Scanner scan;

    public StandardInLottoServiceInputController() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public int getPurchaseAmount() throws InputMismatchException, IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scan.nextInt();
        scan.nextLine();

        if(!ConditionCheck.isPositiveInteger(amount)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다." + System.lineSeparator() + "양의 정수만 입력해주세요.");
        }

        return amount;
    }

    @Override
    public List<Integer> getLastWeekWinningNumber() throws InputMismatchException, IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(",")).map(Integer::valueOf).collect(Collectors.toList());

        if(!numbers.stream().allMatch(ConditionCheck::isLottoNumber)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다." + System.lineSeparator() + "로또 번호 내에서 입력해주세요.");
        }

        if(!ConditionCheck.isDistinctNumbers(numbers)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다." + System.lineSeparator() + "번호 중복없이 입력해주세요.");
        }

        return numbers;
    }
}
