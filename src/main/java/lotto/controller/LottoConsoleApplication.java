package lotto.controller;

import lotto.VO.InvalidFormatException;
import lotto.VO.LackOfMoneyException;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.LottoConsoleView;
import lotto.view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoConsoleApplication implements LottoApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static LottoView VIEW = new LottoConsoleView();

    private Lottos lottos = new Lottos();
    private int accumPayment = 0;
    private int countOfManualLotto = 0;

    public void start() {
        try {
            //금액과 개수를 입력받아 수동 로또를 구매한 후 로또 번호를 출력한다.
            Money money = inputMoney();
            int maxCountOfLotto = money.getAmount() / Lotto.PRICE;
            int countOfManualLotto = inputCountOfManualLotto();

            System.out.println("수동으로 구매할 번호를 입력해주세요.");
            for (int i = 0; i < countOfManualLotto; i++) {
                buyManualLotto(money, inputLotto());
            }
            for (int i = 0; i < maxCountOfLotto - countOfManualLotto; i++) {
                buyRandomLotto(money);
            }
            System.out.println("수동으로 " + countOfManualLotto + "장, 자동으로 " + (maxCountOfLotto - countOfManualLotto) + "장을 구매했습니다.");

            VIEW.printLottos(lottos);

            //추첨된 로또를 입력받아 당첨 여부를 출력한다.
            WinningLotto winningLotto = inputWinLotto();
            LottoResult lottoResult = lottos.match(winningLotto);
            float totalRateOfReturn = (lottoResult.getTotalReturn() - accumPayment) / accumPayment * 100;
            VIEW.printLottoResult(lottoResult, totalRateOfReturn);

        } catch (IllegalArgumentException e) {

            VIEW.printError(e.getMessage());

        }
    }


    public void buyManualLotto(Money payment, Lotto lotto) throws LackOfMoneyException {
        try {
            payment.decrement(Lotto.PRICE);
        } catch (LackOfMoneyException e) {
            throw e;
        }

        this.lottos.add(lotto);
        this.accumPayment += Lotto.PRICE;
        this.countOfManualLotto += 1;
    }

    public void buyRandomLotto(Money payment) throws LackOfMoneyException {
        try {
            payment.decrement(Lotto.PRICE);
        } catch (LackOfMoneyException e) {
            throw e;
        }

        this.lottos.add(LottoGenerator.generateRandomLotto());
    }


    public Money inputMoney() throws InvalidFormatException {
        System.out.println("구매금액을 입력해 주세요.");
        int inputNumber = Integer.parseInt(SCANNER.nextLine().trim());
        ExceptionCheck.validateMoneyNumber(inputNumber);
        return new Money(inputNumber);
    }

    public int inputCountOfManualLotto() throws InvalidFormatException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int inputNumber = Integer.parseInt(SCANNER.nextLine().trim());
        ExceptionCheck.validatePositiveNumber(inputNumber);
        return inputNumber;
    }

    public WinningLotto inputWinLotto() throws InvalidFormatException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lotto inputLotto = inputLotto();
        System.out.println("보너스 볼을 입력해 주세요");
        int inputNumber = Integer.parseInt(SCANNER.nextLine().trim());

        ExceptionCheck.validateLottoNumber(inputNumber);

        return new WinningLotto(inputLotto(), inputNumber);
    }

    public Lotto inputLotto() throws InvalidFormatException {
        Set<Integer> numbers = Arrays.stream(SCANNER.nextLine().trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toSet());

        ExceptionCheck.validateLottoNumbers(numbers);

        return new Lotto(numbers);
    }

}
