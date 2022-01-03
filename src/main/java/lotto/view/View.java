package lotto.view;

import lotto.domain.LottoRow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {

    private Scanner scanner = new Scanner(System.in);

    private static final String SPLIT_DELIMITER = ", ";

    public Integer readPurchaseAmountForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }



}
