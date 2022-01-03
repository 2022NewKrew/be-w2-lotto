package lotto.util;

import lotto.dto.LottoGameDto;

import java.util.Scanner;

// 예외처리
public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);
    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
