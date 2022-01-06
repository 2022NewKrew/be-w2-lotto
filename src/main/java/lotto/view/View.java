package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRating;
import lotto.domain.LottoWinningResult;

import java.util.*;
import java.util.stream.Collectors;

public class View {

    private Scanner scanner = new Scanner(System.in);

    private static final String SPLIT_DELIMITER = ", ";

    public int readPurchaseAmountForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public void printLottoCount(int manualLottoCount, int automaticLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + automaticLottoCount + "개를 구매했습니다.");
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
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
        stringBuilder.append("개 일치");
        if (lottoWinningRating.hasBonusBall()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (" + lottoWinningRating.getWinningMoney());
        stringBuilder.append("원) - ");
        stringBuilder.append(count);
        stringBuilder.append("개");

        return stringBuilder.toString();
    }

    public int readBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int readManualPurchaseCountForLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> readManualLottoNumbers(int manualPurchaseCountForLotto) {
        if (manualPurchaseCountForLotto == 0) {
            return new ArrayList<>();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualPurchaseCountForLotto; i++) {
            manualLottoNumbers.add(Arrays.stream(scanner.nextLine().split(SPLIT_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        return manualLottoNumbers;
    }

}
