package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoApp;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class LottoView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoApp app;

    public void start() {
        app = new LottoApp();
        app.purchaseLotto(inputPrice());
        System.out.println(app.toString());

        app.setWinLotto(inputWinLotto());
        System.out.println(app.getResultString());
    }


    public int inputPrice() {
        System.out.println("구매금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine().trim());
    }

    public WinningLotto inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(inputIntegerList(), inputBonusNumber());
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return Integer.parseInt(SCANNER.nextLine().trim());
    }

    public Lotto inputLotto() {
        return new Lotto(inputIntegerList());
    }

    public List<Integer> inputIntegerList() {
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
