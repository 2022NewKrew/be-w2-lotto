package lottery.web;

import lottery.web.dto.BudgetDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IOController {

    private static Scanner sc = new Scanner(System.in);
    private final LotteryController lotteryController = new LotteryController();

    public void runApp() {
//        BudgetDto budgetDto = new BudgetDto(getBudget());
//        lotteryController.buy(budgetDto);
        getWinningNumbers();
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

        System.out.println(winningNumbers.toString());

        return winningNumbers;
    }

    private void close() {
        sc.close();
    }

}
