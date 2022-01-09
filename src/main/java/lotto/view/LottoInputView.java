package lotto.view;

import lotto.configure.LottoConfigure;
import lotto.result.LottoResult;
import lotto.vo.LottoVO;

import java.io.InputStream;
import java.util.*;

public class LottoInputView {

    public static int inputPurchaseAmount(InputStream inputStream) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return Integer.parseInt(scanner.next()) / LottoConfigure.LOTTO_PRICE;
    }

    public static List<Integer> inputLastWeekLottoNumbers(InputStream inputStream) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lastWeekLottoNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        for (int i = 0; i < LottoConfigure.NUMBERS_SIZE; i++) {
            lastWeekLottoNumbers.add(Integer.parseInt(scanner.next().replace(",","").strip()));
        }
        lastWeekLottoNumbers.sort(Comparator.naturalOrder());
        return lastWeekLottoNumbers;
    }

    public static int inputBonusBall(InputStream inputStream) {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return Integer.parseInt(scanner.next());
    }



}
