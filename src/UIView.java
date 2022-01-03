import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UIView {
    private Scanner scanner = new Scanner(System.in);

    public void print(Object object) {
        System.out.println(object);
    }

    public String inputString() {
        return scanner.nextLine();
    }

    public int inputInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputPurchased() {
        this.print("구입금액을 입력해 주세요.");
        int purchased = this.inputInt();
        return purchased;
    }

    public String inputWinningLotto() {
        this.print("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public void purchaseCompleted(int numOfLotto) {
        this.print(Integer.toString(numOfLotto) + "개를 구매했습니다.");
    }

    public void showStatistics(List<Integer> numberOfWinnings, int yeild) {
        List<Integer> rewards = LottoGame.getRewards();
        this.print("당첨 통계");
        this.print("---------");
        for (int i = 3; i < 7; i++) {
            this.print(Integer.toString(i) + "개 일치 (" + Integer.toString(rewards.get(i)) + "원)- " + Integer.toString(numberOfWinnings.get(i)) + "개");
        }
        this.print("총 수익률은 " + Integer.toString(yeild) + "%입니다.");
    }
}
