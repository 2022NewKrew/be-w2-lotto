package service;

import constant.Constants;
import domain.Lotto;
import domain.LottoNumber;
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
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public Lotto makeLotto(int numberOfLottoTicket) {
        return new Lotto(makeLottoTickets(numberOfLottoTicket));
    }

    private List<LottoTicket> makeLottoTickets(int numberOfLottoTicket) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTicket; i++) {
            lottoTickets.add(makeLottoTicket());
        }

        return lottoTickets;
    }

    private LottoTicket makeLottoTicket() {
        return new LottoTicket(makeLottoNumbers());
    }

    private List<LottoNumber> makeLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(Constants.SIZE_OF_LOTTO_TICKET)
                .collect(Collectors.toUnmodifiableList());
    }
}
