package com.kakao.lottogame.view;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.LottoNumber;
import com.kakao.lottogame.domain.Money;
import com.kakao.lottogame.domain.WinningLotto;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int value = Integer.parseInt(scanner.nextLine());
        return Money.of(value);
    }

    public WinningLotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = removeSpace(scanner.nextLine());
        List<LottoNumber> lottoNumbers = extractNumbers(line);

        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        return WinningLotto.of(Lotto.of(lottoNumbers), LottoNumber.of(bonusNumber));
    }

    private String removeSpace(String line) {
        return line.replaceAll(SPACE, BLANK);
    }

    private List<LottoNumber> extractNumbers(String line) {
        return Arrays.stream(line.split(DELIMITER))
            .distinct()
            .mapToInt(Integer::parseInt)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList());
    }
}
