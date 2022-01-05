package view;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static int getPayPriceInput() {
        int result = -1;
        System.out.println("구입금액을 입력해 주세요.");
        while (!sc.hasNextInt() || ((result = sc.nextInt()) < 0)) {
            System.out.println("양의 점수를 입력해 주세요.");
            sc.next();
        }
        return result;
    }

    public static int getBonusWinningInput() {
        int result = -1;
        System.out.println("보너스 볼을 입력해 주세요.");
        while (!sc.hasNextInt() || ((result = sc.nextInt()) > END_NUMBER) || result < START_NUMBER) {
            System.out.println("1~45 사이의 당첨 번호를 입력해주세요.");
            sc.next();
        }
        return result;
    }

    public static List getWinningInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lottoNumberList = getLottoNumberInput();

        // 적절하지 않은 로또 번호를 입력하면 다시 입력 해야 함.
        return lottoNumberList;
    }

    private static List<Integer> getLottoNumberInput() {
        List<Integer> lottoNumberList;
        do {
            String inputStr = sc.next();
            lottoNumberList = Arrays.asList(inputStr.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        }
        while (!isCorrectWinningList(lottoNumberList));
        return lottoNumberList;
    }

    private static boolean isCorrectWinningList(List<Integer> arrayList) {
        if (arrayList.stream().filter(player -> (player > END_NUMBER) || (player < START_NUMBER)).count() > 0) {
            System.out.println("1~45 사이의 당첨 번호를 입력해주세요.");
            return false;
        }
        if (arrayList.size() != 6) {
            System.out.println("로또 번호를 6개 입력해주세요.");
            return false;
        }
        return true;
    }

    public static List<Lotto> getManualLottoInput(int payManualCount) {
        int num = 0;
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> arrayList = new ArrayList<>();
        while (num < payManualCount) {
            List<Integer> lottoNumberList = getLottoNumberInput();
            arrayList.add(new Lotto(lottoNumberList));
            num++;
        }
        // 적절하지 않은 로또 번호를 입력하면 다시 입력 해야 함.
        return arrayList;
    }

    public static int getManualCountInput(int payCount) {
        int result = -1;
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        while (!sc.hasNextInt() || ((result = sc.nextInt()) > payCount) || result < 0) {
            System.out.println(payCount + "보다 작은 수를 입력해주세요.");
            sc.next();
        }
        return result;
    }
}