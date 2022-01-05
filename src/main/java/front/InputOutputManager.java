package front;

import back.domain.Prize;
import dto.LottoDto;
import front.Printer.LottoPrinter;
import front.Printer.ResultPrinter;
import front.Scanner.PositiveIntScanner;

import java.util.ArrayList;
import java.util.List;

public class InputOutputManager {
    public int getMoney() {
        return PositiveIntScanner.getPositiveInt("구입 금액을 입력해주세요.");
    }

    public int getBonusNumber() {
        return PositiveIntScanner.getPositiveInt("보너스 볼을 입력해주세요.");
    }

    public int getUserCreateCount() {
        return PositiveIntScanner.getPositiveInt("수동으로 구매할 로또 수를 입력하세요.");
    }

    public List<Integer> getWinningSequence() {
        return PositiveIntScanner.getPositiveIntList("지난 주 당첨 번호를 입력해 주세요.");
    }

    public List<List<Integer>> getUserCreateLottoSequenceList(int manualAmount) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < manualAmount; i++)
            output.add(PositiveIntScanner.getPositiveIntList());

        return output;
    }

    public void printLottoList(List<LottoDto> lottoList) {
        int autoLottoCount = (int) lottoList.stream()
                .filter(LottoDto::getAutoCreated).count();
        int manualLottoCount = (int) lottoList.stream()
                .filter(lotto -> !lotto.getAutoCreated()).count();

        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
        lottoList.forEach(LottoPrinter::print);
    }

    public void printResult(List<Prize> prizes, int money) {
        ResultPrinter.print(prizes, money);
    }
}
