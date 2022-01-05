package lotto.view;

import lotto.VO.Rank;
import lotto.domain.LottoResultManager;
import lotto.model.Lotto;
import lotto.domain.LottoApp;

import lotto.domain.Money;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoConsoleView extends LottoView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoApp app;

    public void start() {
        app = new LottoApp();
        try {
            //금액과 개수를 입력받아 수동 로또를 구매한다.
            Money money = inputMoney();
            purchaseCustomLotto(money, inputCountOfCustomLotto());

            //남은 금액만큼 자동 로또를 구매한다.
            app.purchaseLotto(money);

            //구매한 로또 내역을 보여준다.
            printLottoNumbers();

            //추첨된 로또를 입력받아 전달한다.
            app.setWinLotto(inputWinLotto());

            //당첨 여부를 계산한다.
            app.compareHowManyMatch();

            //당첨 결과를 출력한다.
            printLottoResult();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printLottoNumbers() {
        System.out.println("수동으로 " + app.getCountOfCustomLotto() + "장, 자동으로 " + app.getCountOfAutoLotto() + "장을 구매했습니다.");
        System.out.println(app.toString());
    }

    public void printLottoResult() {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");

        LottoResult lottoResult = app.getLottoResult();
        if (lottoResult == null) {
            System.out.println(builder.toString());
            return;
        }

        for (Rank rank : Rank.values()) {
            builder.append(rank.toString());
            builder.append(" - ");
            builder.append(lottoResult.getCountOf(rank));
            builder.append("개");
        }
        builder.append(String.format("총 수익률은 %.2f%% 입니다.", app.calculateRateOfReturn()));
        System.out.println(builder.toString());

    }

    public void purchaseCustomLotto(Money money, int countOfCustomLotto) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        for (int i = 0; i < countOfCustomLotto; i++) {
            app.purchaseCustomLotto(money, _inputLotto());
        }
    }

    public Money inputMoney() throws IllegalArgumentException {
        System.out.println("구매금액을 입력해 주세요.");
        int inputNumber = Integer.parseInt(SCANNER.nextLine().trim());
        return new Money(validatedMoneyNumber(inputNumber));
    }

    public int inputCountOfCustomLotto() throws IllegalArgumentException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int inputNumber = Integer.parseInt(SCANNER.nextLine().trim());
        return validatedPositiveNumber(inputNumber);
    }

    public WinningLotto inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(_inputLotto(), inputBonusNumber());
    }

    public Integer inputBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요");
        return validatedLottoNumber(Integer.parseInt(SCANNER.nextLine().trim()));
    }

    public Lotto _inputLotto() throws IllegalArgumentException {
        List<Integer> numbers = validatedLottoNumbers(_inputLottoNumbers());
        return new Lotto(numbers);
    }

    public List<Integer> _inputLottoNumbers() throws IllegalArgumentException {
        return _inputIntegerStream()
                .distinct()
                .map(x -> validatedLottoNumber(x))
                .collect(Collectors.toList());
    }

    public Stream<Integer> _inputIntegerStream() throws IllegalArgumentException {
        return Arrays.stream(SCANNER.nextLine().trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt);
    }

}
