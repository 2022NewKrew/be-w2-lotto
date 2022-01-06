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

        //BudgetDto budgetDto = new BudgetDto(getBudget());
        int budget = getBudget();
        ArrayList<ArrayList<Integer>> manualLottery = getManualLotteryBundle();
        int priceOfManualLottery = manualLottery.size() * 1000;
        BudgetAndManualLotteryDto budgetDto = new BudgetAndManualLotteryDto(budget - priceOfManualLottery, manualLottery);

        List<LotteryDto> boughtLotteries = lotteryController.buy(budgetDto);
        for (LotteryDto lotto : boughtLotteries) {
            System.out.println(lotto.getNumbers().toString());
        }

        ArrayList<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

//        LotteryWinningNumberDto winningNumberDto = new LotteryWinningNumberDto(winningNumbers);
        LotteryWinningNumberWithBonusDto winningNumberDto = new LotteryWinningNumberWithBonusDto(winningNumbers, bonusNumber);
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

    private int getNumOfManualLottery() {
        printConsole("수동으로 구매할 로또 수를 입력해주세요.");
        int numOfManualLottery = Integer.parseInt(getInputString());

        return numOfManualLottery;
    }

    private ArrayList<ArrayList<Integer>> getManualLotteryBundle() {
        int numOfManualLottery = getNumOfManualLottery();
        printConsole("수동으로 구매할 번호를 입력해 주세요");

        ArrayList<ArrayList<Integer>> manualBundle = new ArrayList<>();
        for (int i = 0; i < numOfManualLottery; i++) {
            manualBundle.add(getManualLotteryNumbers());
        }

        return manualBundle;
    }

    private ArrayList<Integer> getManualLotteryNumbers() {
        ArrayList<String> inputStrArr = new ArrayList<String> (Arrays.asList(getInputString().split(",")));
        ArrayList<Integer> winningNumbers = new ArrayList<Integer>();

        inputStrArr.forEach(el -> winningNumbers.add(Integer.parseInt(el.trim())));

        return winningNumbers;
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
