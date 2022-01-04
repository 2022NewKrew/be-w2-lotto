import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LotteryPrinter {
    private Scanner scanner = new Scanner(System.in);

    public void print(Object object) {
        System.out.println(object);
    }

    private String inputString() {
        return scanner.nextLine();
    }

    private int inputInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputPurchased() {
        this.print("구입금액을 입력해 주세요.");
        return this.inputInt();
    }

    public List<Integer> inputWinningNumbers() {
        this.print("지난 주 당첨 번호를 입력해 주세요.");
        String inputString = this.inputString();
        return stringListToIntegerList(parseWinningNumbers(inputString));
    }

    private List<Integer> stringListToIntegerList(List<String> stringList) {
        return stringList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private List<String> parseWinningNumbers(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","));
    }

    public void purchaseCompleted(int numOfLotto) {
        this.print(String.format("%d개를 구매했습니다.", numOfLotto));
    }

    public void showStatistics(List<Integer> rewards, int rewardLeftBound, int rewardRightBound, List<Integer> numberOfWinnings, int yeild) {
        this.print("당첨 통계");
        this.print("---------");
        for (int i = rewardLeftBound; i < rewardRightBound + 1; i++) {
            this.print(String.format("%d개 일치 (%d원) - %d개", i, rewards.get(i), numberOfWinnings.get(i)));
        }
        this.print(String.format("총 수익률은 %d%%입니다.", yeild));
    }
}
