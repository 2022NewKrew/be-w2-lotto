package domain;

import view.LottoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {

    private int inputPrice;
    private String lottoWinningNumbers;

    private int bonusNumber;
    private Person person;
    private LottoView lottoView;
    private final List<String> manualLottoList = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public LottoGame() {
        consoleInputPrice();
        consoleManualInput();
        init();
        lottoView.showLotto();

        consoleInputLottoWinningNumbers();
        consoleInputBonusNumber();
        Lotto.setLottoWinningNumbers(lottoWinningNumbers, bonusNumber);

        person.setLottoResult();
        lottoView.showResult();
    }

    private void consoleManualInput() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoList.add(scanner.nextLine());
        }
    }

    private void init() {
        if(manualLottoList.size() == 0){
            person = new Person(inputPrice);
            lottoView = new LottoView(person);
            return;
        }
        person = new Person(inputPrice, manualLottoList);
        lottoView = new LottoView(person);
    }

    private void consoleInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        this.bonusNumber = scanner.nextInt();
        scanner.close();
    }

    private void consoleInputLottoWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        lottoWinningNumbers = scanner.nextLine();
    }

    private void consoleInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        inputPrice = scanner.nextInt();
    }
}
