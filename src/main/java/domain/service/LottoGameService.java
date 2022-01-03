package domain.service;

import domain.entity.LottoTicket;
import domain.entity.LottoTickets;
import domain.model.*;
import view.dto.WinningResultResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameService {

    private static final int LOTTO_PRICE = 1000;

    private static final List<Integer> BASE_LOTTO_NUMBERS = new ArrayList<>();

    public LottoGameService() {
        for(int num = 1; num < 46; num++) {
            BASE_LOTTO_NUMBERS.add(num);
        }
    }

    public LottoTickets purchase(int amount) {
        int quantity = calculateLottoQuantity(amount);
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for(int q = 0; q < quantity; q++) {
            lottoTicketList.add(createLottoTicket());
        }
        return new LottoTickets(lottoTicketList);
    };

    private int calculateLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    private LottoTicket createLottoTicket() {
        Collections.shuffle(BASE_LOTTO_NUMBERS);
        List<Integer> lottoNumbers = new ArrayList<>(BASE_LOTTO_NUMBERS.subList(0, 6));
        Collections.sort(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    /**
     * 당첨된 복권을 확인하고, View에서 보여줄 데이터를 만들어 리턴한다.
     */
    public WinningResultResponse checkWinningLotto(LottoTickets lottoTickets, LottoTicket winningTicket) {
        WinningResult winningResult = lottoTickets.getMatchingCountAndProfit(winningTicket);
        int purchaseAmount = lottoTickets.getSize() * LOTTO_PRICE;
        return new WinningResultResponse(winningResult.getCountMap(), (double)winningResult.getProfit() / (double)purchaseAmount);
    }
    
}
