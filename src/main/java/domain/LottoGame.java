package domain;

import view.LottoView;

import java.util.Scanner;

public class LottoGame {

    private int inputPrice;
    private String lottoWinningNumbers;
    private Person person;
    private LottoView lottoView;

    private Scanner scanner = new Scanner(System.in);

    public LottoGame(){
        consoleInputPrice();
        init();
        lottoView.showLotto();

        consoleInputLottoWinningNumbers();
        Lotto.setLottoWinningNumbers(lottoWinningNumbers);

        person.setLottoResult();
        lottoView.showResult();
    }

    private void init(){
        person = new Person(inputPrice);
        lottoView = new LottoView(person);
    }

    private void consoleInputLottoWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        lottoWinningNumbers = scanner.nextLine();
        scanner.close();
    }

    private void consoleInputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        inputPrice = scanner.nextInt();
    }
}
