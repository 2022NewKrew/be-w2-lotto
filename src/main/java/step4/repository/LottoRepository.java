package step4.repository;
import step4.service.domain.LottoBundle;

public interface LottoRepository {
    public LottoBundle save(String id, LottoBundle lottoTicket);
    public LottoBundle getById(String id);
}
