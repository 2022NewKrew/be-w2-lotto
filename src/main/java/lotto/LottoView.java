package lotto;

import java.io.InputStream;
import java.util.*;

public class LottoView {

    public static int inputPurchaseAmount(InputStream inputStream) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return Integer.parseInt(scanner.next()) / LottoDto.LOTTO_PRICE;
    }

    public void outputPurchaseResult(List<LottoDto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static List<Long> inputLastWeekLottoNumbers(InputStream inputStream) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Long> lastWeekLottoNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        for (int i = 0; i < LottoDto.NUMBERS_SIZE; i++) {
            lastWeekLottoNumbers.add(Long.parseLong(scanner.next().replace(",","").strip()));
        }
        lastWeekLottoNumbers.sort(Comparator.naturalOrder());
        return lastWeekLottoNumbers;
    }

    public static int inputBonusBall(InputStream inputStream) {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(inputStream);
        return Integer.parseInt(scanner.next());
    }

    public static void outputLottoResult(List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        long totalProfit = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.getCountOfMatch() < LottoResult.FIFTH.getCountOfMatch()) continue;
            long hit = lottoResult.getCountOfMatch();
            long reward = lottoResult.getWinningMoney();
            long count = Collections.frequency(lottoResults, lottoResult);
            totalProfit += count * reward;
            System.out.printf("%d개 일치 ", hit);
            if (lottoResult.isCheckBonusBall()) System.out.printf("보너스 볼 일치");
            System.out.printf("(%d원)- %d개\n", reward, count);
        }
        long totalLoss = (long)LottoDto.LOTTO_PRICE * lottoResults.size();
        System.out.printf("총 수익률은 %.2f%%입니다.", ((double) totalProfit / (double) totalLoss - 1) * 100);
    }
}
