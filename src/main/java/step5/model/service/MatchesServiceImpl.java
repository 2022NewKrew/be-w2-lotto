package step5.model.service;

import step5.model.domain.Matches;
import step5.model.repository.MatchesRepository;
import step5.model.repository.MatchesRepositoryImpl;

public class MatchesServiceImpl implements MatchesService {
    private static final MatchesService INSTANCE = new MatchesServiceImpl();

    private final MatchesRepository matchesRepository = MatchesRepositoryImpl.getInstance();

    private MatchesServiceImpl() {}

    public static MatchesService getInstance() {
        return INSTANCE;
    }

    @Override
    public Matches selectAllMatchesFromRepository() {
        return matchesRepository.selectAllMatches();
    }

    @Override
    public void updateMatchesInRepository(Matches matches) {
        matchesRepository.updateMatches(matches);
    }
}
