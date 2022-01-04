package view;

import domain.Lotto;
import domain.Prize;
import view.Printer.LottoPrinter;
import view.Printer.ResultPrinter;
import view.Scanner.PositiveIntScanner;

import java.util.List;

public class InputOutputManager {
    public int getMoney() {
        return PositiveIntScanner.getPositiveInt("구입 금액을 입력해주세요.");
    }

    public int getBonusNumber() {
        return PositiveIntScanner.getPositiveInt("보너스 볼을 입력해주세요.");
    }

    public void printLottoList(List<Lotto> lottoList) {
        int lottoCount = lottoList.size();

        if (lottoCount == 0) {
            System.out.println("구입하신 로또가 없습니다.");
            return;
        }

        System.out.println(lottoCount + "개를 구입했습니다.");
        lottoList.forEach(LottoPrinter::print);
    }

    public List<Integer> getWinningSequence() {
        return PositiveIntScanner.getPositiveIntList("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printResult(List<Prize> prizes, int money) {
        ResultPrinter.print(prizes, money);
    }
}
