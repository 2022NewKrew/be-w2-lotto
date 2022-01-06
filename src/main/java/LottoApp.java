import domain.Lotto;
import domain.LottoResults;
import domain.LottoShop;
import dto.YieldDto;
import dto.LottoResultsDto;
import service.LottoGenerator;
import view.LottoInputView;
import view.LottoOutView;



public class LottoApp {

    private static final LottoShop lottoShop = new LottoShop(new LottoGenerator());
    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LottoOutView lottoOutView = new LottoOutView();


    public static void main(String[] args) {
        int money = lottoInputView.inputMoney();
        int numberOfManualLottoTicket = lottoInputView.inputNumberOfManualLottoTicket();
        Lotto lotto = lottoShop.sell(lottoInputView.inputManualLottoTickets(numberOfManualLottoTicket), money);
        lottoOutView.printLotto(lotto.getLottoTicketsView());
        LottoResults lottoResults = lotto.checkLottoResults(lottoInputView.inputWinningNumbers());

        lottoOutView.printLottoResults(new LottoResultsDto(lottoResults));
        lottoOutView.printYield(new YieldDto(lottoResults.getEarnedMoney(), lotto.getPrice()));
    }
}
