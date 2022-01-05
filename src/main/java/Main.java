import lotto.domain.component.WinningLottoTicket;
import lotto.domain.result.LottoResult;
import lotto.dto.GetLottoResultDTO;
import lotto.dto.PurChasingLottoDTO;

import java.io.IOException;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Main {

    public static void main(String[] args) throws IOException {

        PurChasingLottoDTO purChasingLottoDTO = inputPrice();
        printLottoTickets(purChasingLottoDTO);

        WinningLottoTicket winningLottoTicket = inputWinningTicket();
        LottoResult lottoResult = inputLottoResult(new GetLottoResultDTO(winningLottoTicket, purChasingLottoDTO.getLottoTickets(),
                purChasingLottoDTO.getPurchasePrice()));
        printLottoResult(lottoResult);
    }
}
