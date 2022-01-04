package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final String LOTTO_NUMBER_SPLIT_DELIMITER = ", ";

    public int getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return new Scanner(System.in).nextInt();
    }

    public LottoNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> numbers = new ArrayList<>();
        String[] numberStrings = new Scanner(System.in).nextLine().split(LOTTO_NUMBER_SPLIT_DELIMITER);

        for (String string : numberStrings) {
            numbers.add(LottoNumber.from(Integer.parseInt(string)));
        }

        return LottoNumbers.from(numbers);
    }
}
