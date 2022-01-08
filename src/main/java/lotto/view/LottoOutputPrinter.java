package lotto.view;

import static lotto.domain.Lotto.NUM_OF_LOTTO_NUMBERS_IN_LOTTO;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import org.jetbrains.annotations.NotNull;

public interface LottoOutputPrinter {

    String CHECK_LOTTO_NUMBER_MESSAGE = "[Error] 각 번호는 1~45 사이의 숫자 값을 가져야 합니다.\n";
    String CHECK_DUPLICATION_MESSAGE = "[Error] 각 번호는 서로 중복될 수 없습니다.\n";
    String CHECK_NUM_OF_LOTTO_NUMBERS =
        "[Error] 번호는 " + NUM_OF_LOTTO_NUMBERS_IN_LOTTO + "개를 입력해야 합니다.\n";
    String SPACE = " ";
    String PREFIX = "[";
    String SUFFIX = "]";

    void printDescription(String msg);

    void printPurchaseResult(long numOfManualLottos, @NotNull List<Lotto> purchasedLottoList);

    void printWinningResultPrinter(WinningResult winningResult);

    void printWinningYield(double yield);
}
