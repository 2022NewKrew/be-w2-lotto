package output;

import input.dto.InputInfo;
import lotto.domain.LottoTicket;

import java.util.List;

public interface OutputView {
    void show(InputInfo inputInfo, List<LottoTicket> lottoTickets);
}
