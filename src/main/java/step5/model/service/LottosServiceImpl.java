package step5.model.service;

import step5.model.domain.Lottos;
import step5.model.repository.LottosRepository;
import step5.model.repository.LottosRepositoryImpl;

public class LottosServiceImpl implements LottosService {
    private static final LottosService INSTANCE = new LottosServiceImpl();

    private final LottosRepository lottosRepository = LottosRepositoryImpl.getInstance();

    private LottosServiceImpl() {}

    public static LottosService getInstance() {
        return INSTANCE;
    }

    @Override
    public Lottos selectAllLottosFromRepository() {
        return lottosRepository.selectAllLottos();
    }

    @Override
    public void insertLottosToRepository(Lottos lottos) {
        lottosRepository.insertLottos(lottos);
    }
}
