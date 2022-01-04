package output;

import input.dto.InputInfo;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.Map;

public interface OutputView {
    public void printResult(Map<Integer, Integer> results, long profitRate);
}
