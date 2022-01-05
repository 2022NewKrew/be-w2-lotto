package view;

import domain.Rank;
import domain.UIMessage;

import java.util.*;
import java.util.stream.Collectors;

public class LottoUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static long inputMoney() {
        System.out.println(UIMessage.HOW_MONEY.getMessage());
        long money;
        try {
            String input = scanner.nextLine();
            money = Long.parseLong(input);
        } catch (Exception e) {
            money = 0;
        }
        return money;
    }

    private static List<Integer> inputSixNum() {
        String input = scanner.nextLine();
        String replace = input.replace(" ", "");

        return Arrays.stream(replace.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> inputWinningNum() {
        System.out.println(UIMessage.LAST_WINNING_NUM.getMessage());
        return inputSixNum();
    }

    public static List<List<Integer>> inputManualNum() {
        System.out.println(UIMessage.HOW_MANY_MANUAL.getMessage());
        int buyManual;
        try {
            String input = scanner.nextLine();
            buyManual = Integer.parseInt(input);
        } catch (Exception e) {
            buyManual = 0;
        }

        System.out.println(UIMessage.ENTER_MANUAL_NUM.getMessage());
        List<List<Integer>> manualNum = new ArrayList<>();
        for(int buy=0; buy < buyManual; buy++){
            manualNum.add(inputSixNum());
        }
        return manualNum;
    }

    public static int inputBonusNum() {
        System.out.println(UIMessage.BONUS_NUM.getMessage());
        int bonus;
        try {
            String input = scanner.nextLine();
            bonus = Integer.parseInt(input);
        } catch (Exception e) {
            bonus = -1;
        }
        return bonus;
    }

    public static void outputLotto(int total, int manual, String lotto) {
        System.out.printf(UIMessage.BUY_RESULT.getMessage(), manual, total-manual);
        System.out.println(lotto);
    }

    public static void outputWinningResult(HashMap<Rank, Integer> winningResult) {
        StringBuilder result = new StringBuilder();
        result.append("\n당첨 통계\n---------\n");
        Arrays.stream(Rank.values()).forEach(rank -> {
            result.append(rank.getCountOfMatch());
            result.append(rank != Rank.SECOND ? "개 일치 (" : "개 일치, 보너스 볼 일치(");
            result.append(rank.getWinningMoney());
            result.append("원)- ");
            result.append(winningResult.get(rank));
            result.append("개\n");
        });
        System.out.print(result);
    }

    public static void outputWinRate(int winRate) {
        System.out.printf(UIMessage.WIN_RATE.getMessage(), winRate);
    }
}
