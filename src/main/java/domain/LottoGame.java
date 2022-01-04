package domain;

import view.LottoView;

import java.util.Scanner;

public class LottoGame {

    private int inputPrice;
    private String lottoWinningNumbers;

    private int bonusNumber;
    private Person person;
    private LottoView lottoView;

    private final Scanner scanner = new Scanner(System.in);

    public LottoGame(){
        consoleInputPrice();
        init();
        lottoView.showLotto();

        consoleInputLottoWinningNumbers();
        consoleInputBonusNumber();
        Lotto.setLottoWinningNumbers(lottoWinningNumbers, bonusNumber);

        person.setLottoResult();
        lottoView.showResult();
    }

    private void init(){
        person = new Person(inputPrice);
        lottoView = new LottoView(person);
    }

    private void consoleInputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        this.bonusNumber = scanner.nextInt();
        scanner.close();
    }

    private void consoleInputLottoWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        lottoWinningNumbers = scanner.nextLine();
    }

    private void consoleInputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        inputPrice = scanner.nextInt();
    }
}
