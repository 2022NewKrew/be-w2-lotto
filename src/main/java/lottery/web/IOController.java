package lottery.web;

import lottery.web.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOController {

    private static Scanner sc = new Scanner(System.in);
    private final LotteryController lotteryController = new LotteryController();

    public void runApp() {

        BudgetDto budgetDto = new BudgetDto(getBudget());
        List<LotteryDto> boughtLotteries = lotteryController.buy(budgetDto);
        for (LotteryDto lotto : boughtLotteries) {
            System.out.println(lotto.getNumbers().toString());
        }

        ArrayList<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

//        LotteryWinningNumberDto winningNumberDto = new LotteryWinningNumberDto(winningNumbers);
        LotteryWinningNumberDto winningNumberDto = new LotteryWinningNumberWithBonusDto(winningNumbers, bonusNumber);
        LotteryResultDto matchResult = lotteryController.match(winningNumberDto);

        System.out.println(matchResult.toString());

        close();
    }

    private void printConsole(String msg) { System.out.println(msg); }

    private String getInputString() { return sc.nextLine(); }

    private int getBudget() {
        printConsole("구입 금액을 입력해 주세요");
        int budget = Integer.parseInt(getInputString());

        return budget;
    }

    private ArrayList<Integer> getWinningNumbers() {
        printConsole("지난 주 당첨 번호를 입력해 주세요.");
        ArrayList<String> inputStrArr = new ArrayList<String> (Arrays.asList(getInputString().split(",")));
        ArrayList<Integer> winningNumbers = new ArrayList<Integer>();

        inputStrArr.forEach(el -> winningNumbers.add(Integer.parseInt(el.trim())));

        return winningNumbers;
    }

    private int getBonusNumber() {
        printConsole("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(getInputString());

        return bonusNumber;
    }

    private void close() {
        sc.close();
    }

}
