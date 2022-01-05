package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInputView implements InputView {
    private static final String LOTTO_NUMBER_SPLIT_DELIMITER = ", ";

    public int getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return new Scanner(System.in).nextInt();
    }

    // TODO: 원시값을 넘기고 도메인 객체 생성은 컨트롤러에서 하도록 수정
    public LottoNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<LottoNumber> numbers = new HashSet<>();
        String[] numberStrings = new Scanner(System.in).nextLine().split(LOTTO_NUMBER_SPLIT_DELIMITER);

        for (String string : numberStrings) {
            numbers.add(LottoNumber.from(Integer.parseInt(string)));
        }

        return LottoNumbers.from(numbers);
    }

    // TODO: 원시값을 넘기고 도메인 객체 생성은 컨트롤러에서 하도록 수정
    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = new Scanner(System.in).nextInt();

        return LottoNumber.from(bonusNumber);
    }
}
