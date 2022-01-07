package step4.repository;

import step4.service.domain.LottoBundle;

import java.util.HashMap;
import java.util.Map;

public class MemoryLottoRepository implements LottoRepository {
    private final Map<String, LottoBundle> tickets = new HashMap<>();

    @Override
    public LottoBundle save(String id, LottoBundle lottoTicket) {
        tickets.put(id, lottoTicket);

        return lottoTicket;
    }

    public LottoBundle getById(String id) {
        return tickets.get(id);
    }

}
