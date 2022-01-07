import domain.Lotto;
import domain.LottoResults;
import domain.LottoShop;
import domain.LottoTicket;
import view.dto.YieldDto;
import view.dto.LottoResultsDto;
import service.LottoGenerator;
import view.LottoInputView;
import view.LottoOutView;
import view.dto.lottoticket.LottoTicketsInputDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class LottoApp {

    private static final LottoShop lottoShop = new LottoShop(new LottoGenerator());
    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LottoOutView lottoOutView = new LottoOutView();


    public static void main(String[] args) {
        int money = lottoInputView.inputMoney();
        int numberOfManualLottoTicket = lottoInputView.inputNumberOfManualLottoTicket();
        Optional<LottoTicketsInputDto> lottoTicketsInputDto = lottoInputView.inputManualLottoTickets(numberOfManualLottoTicket);
        List<LottoTicket> lottoTickets = lottoTicketsInputDto.map(LottoTicketsInputDto::toLottoTickets).orElse(Collections.emptyList());
        Lotto lotto = lottoShop.sell(lottoTickets, money);
        lottoOutView.printLotto(lotto.getLottoTicketsView());
        LottoResults lottoResults = lotto.checkLottoResults(lottoInputView.inputWinningNumbers());

        lottoOutView.printLottoResults(new LottoResultsDto(lottoResults));
        lottoOutView.printYield(new YieldDto(lottoResults.getEarnedMoney(), lotto.getPrice()));
    }
}
