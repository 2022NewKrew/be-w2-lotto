package view.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static domain.Validator.checkPositiveInteger;
import static domain.Validator.checkSizeOfLotto;

public class ConsoleInputInterface implements InputInterface {
    private Scanner scanner = null;

    @Override
    public void openScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }

    @Override
    public int inputBudget() throws Exception {
        System.out.print("구입금액을 입력해 주세요.\n");

        int budget = Integer.parseInt(scanner.nextLine());
        checkPositiveInteger(budget, "구입금액은 0보다 커야 합니다.");

        return budget;
    }

    @Override
    public List<Integer> inputWinningNumbers() throws Exception {
        System.out.print("지난 주 당첨 번호를 입력해 주세요.\n");

        List<Integer> winningNumbers = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split(","))
                .forEach(number -> winningNumbers.add(Integer.parseInt(number.trim())));
        checkSizeOfLotto(winningNumbers, "당첨 번호의 숫자 개수는 6개여야 합니다.");

        return winningNumbers;
    }
}
