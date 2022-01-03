package domain;

import dto.LottoData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static domain.LottoGameInfo.PRICE_OF_TICKET;
import static domain.Validator.checkSizeOfLotto;

public class LottoGenerator {
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoGenerator() {
        IntStream.rangeClosed(1, 45)
                .forEach(lottoNumbers::add);
    }

    public Lotto generate(LottoData lottoData) throws Exception {
        Lotto lotto = new Lotto();

        for(int i = 0; i < lottoData.getBudget() / PRICE_OF_TICKET; i++)
            lotto.addTicket(generateTicket());

        return lotto;
    }

    private LottoTicket generateTicket() throws Exception {
        Collections.shuffle(lottoNumbers);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers.subList(0, 6));
        checkSizeOfLotto(lottoTicket.getSize(), "생성된 로또의 숫자 개수가 " + Integer.toString(lottoTicket.getSize()) + "개입니다.");

        return lottoTicket;
    }
}
