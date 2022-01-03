import input.dto.InputInfo;
import input.CommandLineInputView;
import lotto.LottoCreatorAuto;
import lotto.LottoStore;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoMain {
    private static CommandLineInputView commandLineInputView = new CommandLineInputView();
    private static LottoStore lottoStore = new LottoStore(new LottoCreatorAuto());

    public static void main(String[] args) {
        InputInfo inputInfo = commandLineInputView.getBuyInfo();
        List<LottoTicket> lottoTickets = buyTickets(inputInfo);
        commandLineInputView.getTargetNum(inputInfo);

    }

    private static List<LottoTicket> buyTickets(InputInfo inputInfo) {
        List<LottoTicket> tickets = lottoStore.buy(inputInfo.getAmountOfTicket());
        tickets.stream().forEach(System.out::println);
        return tickets;
    }
}
