package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoApp;

import lotto.domain.Money;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoApp app;

    public void start() {
        app = new LottoApp();
        try {
            Money money = inputMoney();
            int countOfCustomLotto = inputCountOfCustomLotto();

            System.out.println("수동으로 구매할 번호를 입력해주세요.");
            for(int i=0; i<countOfCustomLotto; i++){
                app.purchaseCustomLotto(money, inputLotto());
            }
            int countOfAutoLotto = app.purchaseLotto(money);

            System.out.println("수동으로 " + countOfCustomLotto +"장, 자동으로 " + countOfAutoLotto + "장을 구매했습니다.");
            System.out.println(app.toString());

            app.setWinLotto(inputWinLotto());
            System.out.println(app.getResultString());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }



    public Money inputMoney() throws IllegalArgumentException{

        System.out.println("구매금액을 입력해 주세요.");
        Integer inputNumber = inputPositiveNumber();
        if (inputNumber % 100 != 0){
            throw new IllegalArgumentException("최소 100원 단위로 입력하세요.");
        }
        return new Money(inputNumber);
    }

    public Integer inputCountOfCustomLotto() throws IllegalArgumentException{
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputPositiveNumber();
    }

    public Integer inputPositiveNumber() throws IllegalArgumentException{
        Integer result = Integer.parseInt(SCANNER.nextLine().trim());
        if (result <= 0){
            throw new IllegalArgumentException(result + "값은 양수가 아닙니다.");
        }
        return result;
    }

    public WinningLotto inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(inputLotto(), inputBonusNumber());
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");

        return validateLottoNumber(Integer.parseInt(SCANNER.nextLine().trim()));
    }

    public Lotto inputLotto() throws IllegalArgumentException{
        List<Integer> validNumbers = inputValidIntegerList();
        if (validNumbers.size() != Lotto.N_NUMBERS){
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }
        return new Lotto(validNumbers);
    }

    public List<Integer> inputValidIntegerList() throws IllegalArgumentException{
        return inputIntegerStream()
                .distinct()
                .map(x -> validateLottoNumber(x))
                .collect(Collectors.toList());
    }

    public Integer validateLottoNumber(Integer number) throws IllegalArgumentException{
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER){
            throw new IllegalArgumentException(Lotto.MIN_NUMBER + " 에서 " + Lotto.MAX_NUMBER + " 사이의 값을 입력하세요");
        }
        return number;
    }

    public Stream<Integer> inputIntegerStream() throws IllegalArgumentException{
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt);
    }

}
