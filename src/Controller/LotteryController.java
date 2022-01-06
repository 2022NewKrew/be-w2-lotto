package Controller;

import Domain.RewardRule;
import Exceptions.TicketFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LotteryController {
    private Scanner scanner = new Scanner(System.in);

    public static void print(Object object) {
        System.out.println(object);
    }

    private String inputString() {
        return scanner.nextLine();
    }

    private int inputInt() {
        String inputString = scanner.nextLine();
        try {
            Integer.parseInt(inputString);
        }
        catch (NumberFormatException e) {
            print(String.format("입력하신 '%s' 는 정수가 아닙니다. 다시 입력해 주세요.", inputString));
            return inputInt();
        }
        return Integer.parseInt(inputString);
    }

    public int inputPurchasedPrice() {
        print("구입금액을 입력해 주세요.");
        return this.inputInt();
    }

    public int inputNumOfManualTickets() {
        print("수동으로 구매할 로또 수를 입력해 주세요.");
        return this.inputInt();
    }

    public void printInputManualTicketsMessage() {
        print("수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<Integer> inputCustomTicket() {
        List<String> parsedNumbers = new ArrayList<>();
        try {
            parsedNumbers = parseSelectedNumbers(inputString());
        } catch (TicketFormatException e) {
            return inputCustomTicket();
        } catch (NumberFormatException e) {
            print(e.getMessage());
            return inputCustomTicket();
        }
        return stringListToIntegerList(parsedNumbers);
    }

    public List<Integer> inputWinningNumbers() {
        print("지난 주 당첨 번호를 입력해 주세요.");
        return inputCustomTicket();
    }

    public int inputBonusBall() {
        print("보너스 볼을 입력해 주세요.");
        return this.inputInt();
    }

    private List<Integer> stringListToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        try {
            integerList = stringList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        }
        catch (NumberFormatException e) {
            print(e.getMessage());
            inputCustomTicket();
        }
        return integerList;
    }

    private List<String> parseSelectedNumbers(String winningNumbers) throws TicketFormatException {
        if (winningNumbers.split((",")).length != 6) {
            throw new TicketFormatException();
        }
        return Arrays.asList(winningNumbers.split(","));
    }

    public void purchaseCompleted(int numOfManualTickets, int numOfAutoTickets) {
        print(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", numOfManualTickets, numOfAutoTickets));
    }

    public void showStatistics(List<Integer> numberOfWinnings, int yeild) {
        print("당첨 통계");
        print("---------");
        for (int i = 0; i < numberOfWinnings.size(); i++) {
            showNumberOfWinnings(i, numberOfWinnings.get(i));
        }
        print(String.format("총 수익률은 %d%%입니다.", yeild));
    }

    private void showNumberOfWinnings(int rewardIndex, int numberOfWinning) {
        String rewardName = RewardRule.getRewardName().get(rewardIndex);
        if (RewardRule.valueOf(rewardName).getIsBonus()) {
            print(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개",
                    RewardRule.valueOf(rewardName).getNumOfMatch(), RewardRule.valueOf(rewardName).getReward(), numberOfWinning));
            return;
        }
        print(String.format("%d개 일치, (%d원) - %d개",
                RewardRule.valueOf(rewardName).getNumOfMatch(), RewardRule.valueOf(rewardName).getReward(), numberOfWinning));
    }
}
