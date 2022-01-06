package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public static class LazyHolder {
        public static final InputView INSTANCE = new InputView(new Scanner(System.in));
    }

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        scanner.nextLine(); //버퍼 비우기

        return price;
    }

    public int inputBuyingLottoCnt() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int cnt = scanner.nextInt();
        scanner.nextLine();

        return cnt;
    }

    public List<List<Integer>> inputBuyingLottoNumbers(int cnt) {
        List<List<Integer>> numbersList = new ArrayList<>();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        for (int i = 0; i < cnt; i++) {
            String str = scanner.nextLine();

            List<Integer> lottoNumber = Arrays.asList(str.split(","))
                    .stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            numbersList.add(lottoNumber);
        }
        return numbersList;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine(); //버퍼 비우기

        return bonusNumber;
    }

    public List<Integer> inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String str = scanner.nextLine();

        return Arrays.asList(str.split(","))
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
