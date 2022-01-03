import input.InputResourceManager;
import input.dto.InputInfo;
import input.CommandLineInputView;
import lotto.LottoCreatorAuto;
import lotto.LottoStore;
import lotto.domain.LottoTicket;
import output.CommandLineOutputView;
import output.OutputView;
import input.InputView;

import java.util.List;

public class LottoMain {
    private static InputView InputView = new CommandLineInputView();
    private static LottoStore lottoStore = new LottoStore(new LottoCreatorAuto());
    private static OutputView outputView = new CommandLineOutputView();

    public static void main(String[] args) {
        InputInfo inputInfo = InputView.inputBuyInfo();

        List<LottoTicket> lottoTickets = buyTickets(inputInfo);
        printTickets(lottoTickets);

        InputView.inputTargetNum(inputInfo);
        outputView.show(inputInfo, lottoTickets);

        InputResourceManager.close();
    }

    private static void printTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream().forEach(System.out::println);
    }

    private static List<LottoTicket> buyTickets(InputInfo inputInfo) {
        List<LottoTicket> tickets = lottoStore.buy(inputInfo.getAmountOfTicket());
        return tickets;
    }
}
