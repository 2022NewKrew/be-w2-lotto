package view.input;

import domain.LottoConfig;

import java.util.Scanner;

public class LottoConfigBasicConsoleReader implements ConfigInputReader {
    @Override
    public LottoConfig readConfig(Scanner sc) {
        System.out.println("구입금액을 입력해주세요.");
        final int purchaseAmount = Integer.parseInt(sc.nextLine());
        return new LottoConfig(purchaseAmount);
    }
}
