package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRating;
import lotto.domain.LottoWinningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {

    private Scanner scanner = new Scanner(System.in);

    private static final String SPLIT_DELIMITER = ", ";
    private static final String OPEN_STRING = "[";
    private static final String CLOSE_STRING = "]";
    private static final String SPLIT_STRING = ",";

    public Integer readPurchaseAmountForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLotto(List<Lotto> lottoRows) {
        for (Lotto lottoRow : lottoRows) {
            System.out.println(lottoRow.getLottoNumbers());
        }
    }

    public void printLottoWinningResult(LottoWinningResult lottoWinningResult) {
        System.out.println("당첨 통계");
        System.out.println("------------");

        for (LottoWinningRating lottoWinningRating : lottoWinningResult.keySet()) {
            System.out.println(makeLottoWinningResultText(lottoWinningRating, lottoWinningResult.getLottoWinningCount(lottoWinningRating)));
        }
    }

    public void printYield(long yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private String makeLottoWinningResultText(LottoWinningRating lottoWinningRating, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoWinningRating.getMatchCount());
        stringBuilder.append("개 일치 (");
        stringBuilder.append(lottoWinningRating.getWinningMoney());
        stringBuilder.append("원)- ");
        stringBuilder.append(count);
        stringBuilder.append("개");

        return stringBuilder.toString();
    }

}
