package front;

import back.domain.Prize;
import dto.LottoDto;
import exception.IllegalInputException;
import front.Printer.LottoPrinter;
import front.Printer.ResultPrinter;
import front.Scanner.IntScanner;
import front.Validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputOutputManager {
    public int getBudget() {
        System.out.println("구입 금액을 입력해주세요.");
        while (true) {
            try {
                int budget = IntScanner.getInt();
                Validator.checkWholeNumber(budget);
                return budget;
            } catch (IllegalInputException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningSequence) {
        System.out.println("보너스 볼을 입력해주세요.");
        while (true) {
            try {
                int bonusBallNumber = IntScanner.getInt();
                Validator.checkBonusBallNumberValidity(bonusBallNumber, winningSequence);
                return bonusBallNumber;
            } catch (IllegalInputException e) {
                System.out.println("오류 발생:" + e.getMessage());
            }
        }
    }

    public int getManualCount(int budget) {
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        while (true) {
            try {
                int manualCount = IntScanner.getInt();
                Validator.checkManualCount(manualCount, budget);
                return manualCount;
            } catch (IllegalInputException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
    }

    public List<Integer> getWinningSequence() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        while (true) {
            try {
                List<Integer> winningSequence = IntScanner.getIntList();
                Validator.checkLottoSequence(winningSequence);
                return winningSequence;
            } catch (IllegalInputException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
    }

    public List<List<Integer>> getManualLottoSequenceList(int manualAmount) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<List<Integer>> output = new ArrayList<>();
        while (true) {
            try {
                for (int i = 0; i < manualAmount; i++) {
                    List<Integer> manualSequence = IntScanner.getIntList();
                    Validator.checkLottoSequence(manualSequence);
                    output.add(manualSequence);
                }
                return output;
            } catch (IllegalInputException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }
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
