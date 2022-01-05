package com.upperleaf.view;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.lotto.LottoWinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    private final Scanner sc = new Scanner(System.in);

    /**
     * 로또 지불 정보를 입력받는 메서드
     * @return 로또 지불 정보를 표현하는 객체
     */
    public LottoPaymentInfo inputPaymentInfoByUser() {
        System.out.println("구입 금액을 입력해 주세요.");
        long paymentAmount = Long.parseLong(sc.nextLine());

        return new LottoPaymentInfo(paymentAmount);
    }

    /**
     * 로또 당첨 정보를 입력받는 메서드
     * @return 로또 당첨 정보를 표현하는 객체
     */
    public LottoWinningNumber inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = sc.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        String winningBonusNumbers = sc.nextLine();

        return new LottoWinningNumber(splitAndConvertToInt(winningNumbers), Integer.parseInt(winningBonusNumbers));
    }

    private List<Integer> splitAndConvertToInt(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> Integer.valueOf(number.trim()))
                .collect(Collectors.toList());
    }
}
