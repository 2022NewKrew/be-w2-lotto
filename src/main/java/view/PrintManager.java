package view;

import CONST.Const;

import java.text.DecimalFormat;
import java.util.HashMap;

public class PrintManager {


    public static void printLottos(String lottoString) {
        System.out.println(lottoString);
    }

    public static void printResult(HashMap<Integer, Integer> resultMap) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(Const.SHOW_RESULT).append("\n");
        resultString.append(Const.CORRECT_THREE).append(resultMap.get(3)).append("\n");
        resultString.append(Const.CORRECT_FOUR).append(resultMap.get(4)).append("\n");
        resultString.append(Const.CORRECT_FIVE).append(resultMap.get(5)).append("\n");
        resultString.append(Const.CORRECT_FIVE_BONUS).append(resultMap.get(7)).append("\n");
        resultString.append(Const.CORRECT_SIX).append(resultMap.get(6));
        System.out.println(resultString);
    }

    public static void printWinRate(double winRate) {
        StringBuilder winRateString = new StringBuilder();
        DecimalFormat form = new DecimalFormat("#.##");
        winRateString.append(Const.WIN_RATE_PREFIX).append(form.format(winRate)).append(Const.WIN_RATE_POSTFIX);
        System.out.println(winRateString);
    }
}