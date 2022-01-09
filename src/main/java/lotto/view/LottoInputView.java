package lotto.view;

import lotto.configure.LottoConfigure;
import lotto.result.LottoResult;
import lotto.vo.LottoVO;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class LottoInputView {

    private static List<Integer> inputLottoNumberByScanner(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().replace(" ", "").split(","))
                .map(Integer::parseInt).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static int inputPurchaseAmount(InputStream inputStream) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return Integer.parseInt(scanner.nextLine()) / LottoConfigure.LOTTO_PRICE;
    }

    public static List<List<Integer>> inputPurchaseByUserNumbers(InputStream inputStream) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> userNumers = new ArrayList<>();
        for (int i = 0; i < count; i++){
            userNumers.add(inputLottoNumberByScanner(scanner));
        }
        return userNumers;
    }

    public static List<Integer> inputLastWeekLottoNumbers(InputStream inputStream) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return inputLottoNumberByScanner(scanner);
    }

    public static int inputBonusBall(InputStream inputStream) {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return Integer.parseInt(scanner.nextLine());
    }

}
