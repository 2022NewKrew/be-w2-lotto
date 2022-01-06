package lotto.service;

import lotto.domain.*;
import lotto.domain.result.LottoResult;
import lotto.dto.LottoCheckRequestDto;
import lotto.dto.LottoCheckResponseDto;
import lotto.dto.LottoPurchaseResponseDto;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.domain.Ticket;

import java.util.List;

public class LottoService {

    private LottoService() {
        throw new AssertionError();
    }

    public static int calculateLottoPurchaseCount(int purchaseAmount) {
        return LottoPrice.calculateLottoPurchaseCount(purchaseAmount);
    }

    public static LottoPurchaseResponseDto purchaseLottoBundle(LottoPurchaseRequestDto lottoPurchaseRequestDto) {
        TicketBundle ticketBundle = TicketBundle.purchaseLottoBundle(
                lottoPurchaseRequestDto.getTotalPurchaseCount(),
                lottoPurchaseRequestDto.getManualPurchaseCount(),
                lottoPurchaseRequestDto.getLottoNumbersList()
        );
        return new LottoPurchaseResponseDto(ticketBundle);
    }

    public static LottoCheckResponseDto checkLottoBundle(LottoCheckRequestDto lottoCheckRequestDto) {
        Ticket winningTicket = new Ticket(lottoCheckRequestDto.getWinningNumberList());
        int bonusNumber = lottoCheckRequestDto.getBonusNumber();
        List<Ticket> ticketList = lottoCheckRequestDto.getLottoBundle();
        LottoResult lottoResult = LottoResult.init().check(ticketList, winningTicket, bonusNumber);
        return new LottoCheckResponseDto(lottoResult);
    }
}
