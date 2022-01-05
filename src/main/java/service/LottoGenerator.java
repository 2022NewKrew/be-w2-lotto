package service;

import constant.Constants;
import domain.Lotto;
import domain.lottonumber.BasicNumber;
import domain.lottonumber.LottoNumber;
import domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoGenerator() {
        initialize();
    }

    private void initialize() {
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new BasicNumber(i));
        }
    }

    public Lotto makeLotto(List<LottoTicket> manualLottoTickets, int numberOfAutoLottoTicket) {
        return new Lotto(makeLottoTickets(manualLottoTickets, numberOfAutoLottoTicket));
    }

    private List<LottoTicket> makeLottoTickets(List<LottoTicket> manualLottoTickets, int numberOfAutoLottoTicket) {
        List<LottoTicket> lottoTickets = new ArrayList<>(manualLottoTickets);
        for (int i = 0; i < numberOfAutoLottoTicket; i++) {
            lottoTickets.add(makeAutoLottoTicket());
        }

        return lottoTickets;
    }

    private LottoTicket makeAutoLottoTicket() {
        return new LottoTicket(makeAutoLottoNumbers());
    }

    private List<LottoNumber> makeAutoLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(Constants.SIZE_OF_LOTTO_TICKET)
                .collect(Collectors.toUnmodifiableList());
    }
}
